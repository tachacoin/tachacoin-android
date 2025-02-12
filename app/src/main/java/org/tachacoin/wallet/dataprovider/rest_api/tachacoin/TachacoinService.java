package org.tachacoin.wallet.dataprovider.rest_api.tachacoin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.tachacoin.wallet.model.gson.BlockChainInfo;

import org.tachacoin.wallet.model.gson.CallSmartContractRequest;
import org.tachacoin.wallet.model.gson.ContractParams;
import org.tachacoin.wallet.model.gson.DGPInfo;
import org.tachacoin.wallet.model.gson.ExistContractResponse;
import org.tachacoin.wallet.model.gson.FeePerKb;
import org.tachacoin.wallet.model.gson.QstoreContractType;
import org.tachacoin.wallet.model.gson.call_smart_contract_response.CallSmartContractResponse;
import org.tachacoin.wallet.model.gson.history.History;
import org.tachacoin.wallet.model.gson.history.HistoryResponse;
import org.tachacoin.wallet.model.gson.SendRawTransactionRequest;
import org.tachacoin.wallet.model.gson.SendRawTransactionResponse;
import org.tachacoin.wallet.model.gson.UnspentOutput;
import org.tachacoin.wallet.model.gson.history.TransactionReceipt;
import org.tachacoin.wallet.model.gson.qstore.ContractPurchase;
import org.tachacoin.wallet.model.gson.qstore.QSearchItem;
import org.tachacoin.wallet.model.gson.qstore.QstoreBuyResponse;
import org.tachacoin.wallet.model.gson.qstore.QstoreByteCodeResponse;
import org.tachacoin.wallet.model.gson.qstore.QstoreContract;
import org.tachacoin.wallet.model.gson.qstore.QstoreItem;
import org.tachacoin.wallet.model.gson.qstore.QstoreSourceCodeResponse;
import org.tachacoin.wallet.model.gson.token_history.TokenHistoryResponse;
import org.tachacoin.wallet.utils.CurrentNetParams;

import java.security.KeyStore;
import java.security.SecureRandom;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class TachacoinService {

    private static TachacoinService sTachacoinService;
    private TachacoinRestService mServiceApi;

    public static TachacoinService newInstance() {
        if (sTachacoinService == null) {
            sTachacoinService = new TachacoinService();
        }
        return sTachacoinService;
    }

    private TachacoinService() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {

                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder client = new OkHttpClient.Builder();
            client.interceptors().add(httpLoggingInterceptor);
            client.readTimeout(180, TimeUnit.SECONDS);
            client.connectTimeout(180, TimeUnit.SECONDS);

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "keystore_pass".toCharArray());
            sslContext.init(null, trustAllCerts, new SecureRandom());
            client.sslSocketFactory(sslContext.getSocketFactory())
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    });

            Gson gson = new GsonBuilder().setLenient().create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(CurrentNetParams.getUrl())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(client.build())
                    .build();

            mServiceApi = retrofit.create(TachacoinRestService.class);
        } catch (Exception ignored) {
        }
    }

    public Observable<List<UnspentOutput>> getUnspentOutputs(final String address) {
        return mServiceApi.getOutputsUnspent(address);
    }

    public Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses(final List<String> addresses) {
        return mServiceApi.getUnspentOutputsForSeveralAddresses(addresses);
    }

    public Observable<HistoryResponse> getHistoryListForSeveralAddresses(final List<String> addresses, final int limit, final int offset) {
        return mServiceApi.getHistoryListForSeveralAddresses(limit, offset, addresses);
    }

    public Observable<List<History>> getHistoryList(final String address, final int limit, final int offset) {
        return mServiceApi.getHistoryList(address, limit, offset);
    }

    public Observable<BlockChainInfo> getBlockChainInfo() {
        return mServiceApi.getBlockChainInfo();
    }

    public Observable<FeePerKb> getEstimateFeePerKb(int nBlock) {
        return mServiceApi.getEstimateFeePerKb(nBlock);
    }

    public Observable<SendRawTransactionResponse> sendRawTransaction(final SendRawTransactionRequest sendRawTransactionRequest) {
        return mServiceApi.sendRawTransaction(sendRawTransactionRequest);
    }

    public Observable<CallSmartContractResponse> callSmartContract(String contractAddress, final CallSmartContractRequest callSmartContractRequest) {
        return mServiceApi.callSmartContract(contractAddress, callSmartContractRequest);
    }

    public Observable<History> getTransaction(final String txHash) {
        return mServiceApi.getTransaction(txHash);
    }

    public Observable<List<QstoreItem>> getTrendingNow() {
        return mServiceApi.getTrendingNow();
    }

    public Observable<List<QstoreItem>> getWatsNew() {
        return mServiceApi.getWatsNew();
    }

    public Observable<List<QSearchItem>> searchContracts(int offset, String type, String data, boolean byTag) {
        if (byTag) {
            return mServiceApi.getSearchContracts(20, offset, type, new String[]{data});
        } else {
            return mServiceApi.getSearchContracts(20, offset, type, data);
        }
    }

    public Observable<QstoreContract> getContractById(String id) {
        return mServiceApi.getContract(id);
    }

    public Observable<Object> getAbiByContractId(String contractId) {
        return mServiceApi.getAbiByContractId(contractId);
    }

    public Observable<QstoreBuyResponse> buyRequest(String contractId) {
        return mServiceApi.buyRequest(contractId);
    }

    public Observable<ContractPurchase> isPaidByRequestId(String contractId, String requestId) {
        return mServiceApi.isPaidByRequestId(contractId, requestId);
    }

    public Observable<DGPInfo> getDGPInfo() {
        return mServiceApi.getDGPInfo();
    }

    public Observable<QstoreSourceCodeResponse> getSourceCode(String contractId, String requestId, String accessToken) {

        HashMap<String, String> body = new HashMap<>();
        body.put("request_id", requestId);
        body.put("access_token", accessToken);
        return mServiceApi.getSourceCode(contractId, body);
    }

    public Observable<QstoreByteCodeResponse> getByteCode(String contractId, String requestId, String accessToken) {
        HashMap<String, String> body = new HashMap<>();
        body.put("request_id", requestId);
        body.put("access_token", accessToken);
        return mServiceApi.getByteCode(contractId, body);
    }

    public Observable<List<QstoreContractType>> getContractTypes() {
        return mServiceApi.getContractTypes();
    }

    public Observable<ContractParams> getContractParams(String contractAddress) {
        return mServiceApi.getContractParams(contractAddress);
    }


    public Observable<ExistContractResponse> isContractExist(String contractAddress) {
        return mServiceApi.isContractExist(contractAddress);
    }

    public Observable<TokenHistoryResponse> getTokenHistoryList(String qrc20ContractAddress, int limit, int offset, List<String> addresses){
        return mServiceApi.getTokenHistoryList(qrc20ContractAddress, limit, offset, addresses);
    }

    public Observable<List<TransactionReceipt>> getTransactionReceipt(String txHash){
        return mServiceApi.getTransactionReceipt(txHash);
    }

}