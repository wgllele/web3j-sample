package com.ethjava;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.protocol.ipc.WindowsIpcService;
import org.web3j.tx.ChainIdLong;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Convert;

import com.ethjava.contract.PkContract;

public class TestContract {
	private static Logger log = LoggerFactory.getLogger(TestContract.class);
	private static final long WEB3_TIMEOUT = 3;
	private static final BigInteger gasPrice = Convert.toWei("18", Convert.Unit.GWEI).toBigInteger();
	private static final BigInteger gasLimit = new BigInteger("8000000");
	private static final ContractGasProvider contractGasProvider = new StaticGasProvider(gasPrice,gasLimit);
	
	
	public static void main(String[] args) throws Exception {
		String blockChainUrl="";
		Web3jService web3jService = buildService(blockChainUrl);
		Admin admin = Admin.build(web3jService);
		Credentials credentials =Credentials.create("");
		RawTransactionManager transactionManager = new RawTransactionManager(admin, credentials,
				ChainIdLong.ROPSTEN);

		PkContract pkContract = PkContract.deploy(admin, transactionManager, contractGasProvider, BigInteger.ZERO).send();
		System.out.println(pkContract);
	}
	public static Admin admin(String clientAddress) {
		Web3jService web3jService = buildService(clientAddress);
		log.info("Building admin service for endpoint: " + clientAddress);
		return Admin.build(web3jService);
	}
	public static Web3jService buildService(String clientAddress) {
		Web3jService web3jService;

		if (clientAddress == null || clientAddress.equals("")) {
			web3jService = new HttpService(createOkHttpClient());
		} else if (clientAddress.startsWith("http")) {
			web3jService = new HttpService(clientAddress, createOkHttpClient(), false);
		} else if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
			web3jService = new WindowsIpcService(clientAddress);
		} else {
			web3jService = new UnixIpcService(clientAddress);
		}

		return web3jService;
	}

	public static OkHttpClient createOkHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		configureLogging(builder);
		configureTimeouts(builder);
		return builder.build();
	}

	public static void configureTimeouts(OkHttpClient.Builder builder) {
		builder.connectTimeout(WEB3_TIMEOUT, TimeUnit.SECONDS);
		builder.readTimeout(WEB3_TIMEOUT, TimeUnit.SECONDS); // Sets the socket timeout too
		builder.writeTimeout(WEB3_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void configureLogging(OkHttpClient.Builder builder) {
		if (log.isDebugEnabled()) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor(log::debug);
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			builder.addInterceptor(logging);
		}
	}
}
