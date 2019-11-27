package com.ethjava;

import java.util.Arrays;

import org.web3j.codegen.SolidityFunctionWrapperGenerator;

public class GenContract {

	public static void main(String[] args) {
		String packageName = "com.ethjava.contract";
		String outDirPath = "C:\\Users\\wgl\\git\\web3j-sample\\src\\main\\java";

		String binFilePath = "C:\\Users\\wgl\\git\\web3-hpb-test\\src\\main\\resources\\";
		String abiFilePath = "C:\\Users\\wgl\\git\\web3-hpb-test\\src\\main\\resources\\";
		String[] contracts=new String[]{
				"LotteryContract",
				"LotteryRandom",
				"LotteryService",
				"PkContract",
				"PkContractService"
				
		};
		for(String contract:contracts){
			GenContractJavaCode(packageName, binFilePath+contract+".bin", abiFilePath+contract+".abi", outDirPath);
		}
	}
	public static void GenContractJavaCode(String packageName, String binFilePath, String abiFilePath,
			String outDirPath) {
		try {
			SolidityFunctionWrapperGenerator.main(
					Arrays.asList(
							"-b", binFilePath, 
							"-a", abiFilePath, 
							"-p", packageName, 
							"-o", outDirPath
					).toArray(new String[0])
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
