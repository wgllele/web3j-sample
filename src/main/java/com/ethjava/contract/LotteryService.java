package com.ethjava.contract;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.StaticArray5;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class LotteryService extends Contract {
    private static final String BINARY = "6080604090815260008054600160a060020a03199081163317808355600160a060020a03168083526001602052929091208054909116909117905561163f806100496000396000f3fe6080604052600436106100dc5760e060020a60003504630cf97243811461011457806320d64ef01461015b57806327e1f7df146102825780632e1a7d4d146102b557806335d5d311146102d257806341c0e1b5146102f957806345a6929d14610301578063538ba4f9146103325780635f2ef3b0146103bc578063704802751461042057806371d78b12146104535780638da5cb5b14610468578063b4aca6301461047d578063b61f346d14610492578063dbbc830b146104a7578063e9e085e4146104da578063f2fde38b14610504578063f4655e0414610539575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561012057600080fd5b506101476004803603602081101561013757600080fd5b5035600160a060020a031661056c565b604080519115158252519081900360200190f35b34801561016757600080fd5b5061018b6004803603604081101561017e57600080fd5b5080359060200135610669565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156101d35781810151838201526020016101bb565b505050509050018481038352868181518152602001915080516000925b818410156102325760208085028401015160a080838360005b83811015610221578181015183820152602001610209565b5050505090500192600101926101f0565b878103855288518152885160209182019450818a01935002905080838360005b8381101561026a578181015183820152602001610252565b50505050905001965050505050505060405180910390f35b34801561028e57600080fd5b50610147600480360360208110156102a557600080fd5b5035600160a060020a03166108c0565b610147600480360360208110156102cb57600080fd5b5035610a0e565b3480156102de57600080fd5b506102e7610ae0565b60408051918252519081900360200190f35b610147610be3565b34801561030d57600080fd5b50610316610c73565b60408051600160a060020a039092168252519081900360200190f35b34801561033e57600080fd5b50610347610c82565b6040805160208082528351818301528351919283929083019185019080838360005b83811015610381578181015183820152602001610369565b50505050905090810190601f1680156103ae5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156103c857600080fd5b506103d1610ca5565b604051600160a060020a0384168152602081018360a080838360005b838110156104055781810151838201526020016103ed565b50505050905001828152602001935050505060405180910390f35b34801561042c57600080fd5b506101476004803603602081101561044357600080fd5b5035600160a060020a0316610e50565b34801561045f57600080fd5b50610347610f34565b34801561047457600080fd5b50610316610f59565b34801561048957600080fd5b50610316610f68565b34801561049e57600080fd5b50610147610f77565b3480156104b357600080fd5b50610316600480360360208110156104ca57600080fd5b5035600160a060020a03166111d3565b3480156104e657600080fd5b506103d1600480360360208110156104fd57600080fd5b50356111ee565b34801561051057600080fd5b506105376004803603602081101561052757600080fd5b5035600160a060020a03166113ae565b005b34801561054557600080fd5b506101476004803603602081101561055c57600080fd5b5035600160a060020a0316611513565b3360009081526001602090815260408083205481518083019092526006825260d160020a6518189c181819029282019290925290600160a060020a031615156106365760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156105fb5781810151838201526020016105e3565b50505050905090810190601f1680156106285780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b505060038054600160a060020a03831673ffffffffffffffffffffffffffffffffffffffff199091161790556001919050565b600254604080518082019091526006815260d160020a6518189c18181902602082015260609182918291600160a060020a031615156106ed5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600354604080518082019091526006815260d160020a6518189c18181902602082015290600160a060020a0316151561076c5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b5083851061077957600080fd5b6040805160018787030180825260208082028301019092526060908280156107ab578160200160208202803883390190505b5090506060826040519080825280602002602001820160405280156107ea57816020015b6107d76115d4565b8152602001906001900390816107cf5790505b509050606083604051908082528060200260200182016040528015610819578160200160208202803883390190505b509050885b888110156108b05760006108306115d4565b600061083b846111ee565b89519295509093509150839088908f870390811061085557fe5b600160a060020a039092166020928302909101909101528551829087908f870390811061087e57fe5b602090810290910101528451819086908f870390811061089a57fe5b602090810291909101015250505060010161081e565b5091955093509150509250925092565b6000805460408051808201909152600681526000805160206115f4833981519152602082015290600160a060020a031633146109415760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600160a060020a038281166000908152600160209081526040918290205482518084019093526006835260d160020a6518189c181819029183019190915290911615156109d45760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b5050600160a060020a03166000908152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff1916905590565b6000805460408051808201909152600681526000805160206115f4833981519152602082015290600160a060020a03163314610a8f5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b503031821115610a9e57600080fd5b60008054604051600160a060020a039091169184156108fc02918591818181858888f19350505050158015610ad7573d6000803e3d6000fd5b50600192915050565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a03161515610b605760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600260009054906101000a9004600160a060020a0316600160a060020a03166335d5d3116040518163ffffffff1660e060020a02815260040160206040518083038186803b158015610bb257600080fd5b505afa158015610bc6573d6000803e3d6000fd5b505050506040513d6020811015610bdc57600080fd5b5051905090565b6000805460408051808201909152600681526000805160206115f4833981519152602082015290600160a060020a03163314610c645760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600054600160a060020a0316ff5b600254600160a060020a031681565b604080518082019091526006815260d160020a6518189c18181902602082015281565b6000610caf6115d4565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a03161515610d2f5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600354604080518082019091526006815260d160020a6518189c18181902602082015290600160a060020a03161515610dae5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600260009054906101000a9004600160a060020a0316600160a060020a0316635f2ef3b06040518163ffffffff1660e060020a02815260040160e06040518083038186803b158015610e0057600080fd5b505afa158015610e14573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060e0811015610e3957600080fd5b50805160c082015190956020909201945092509050565b6000805460408051808201909152600681526000805160206115f4833981519152602082015290600160a060020a03163314610ed15760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600160a060020a038281166000908152600160205260409020541615610ef757600080fd5b50600160a060020a03166000818152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff191690921790915590565b60408051808201909152600681526000805160206115f4833981519152602082015281565b600054600160a060020a031681565b600354600160a060020a031681565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a03161515610ff75760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600354604080518082019091526006815260d160020a6518189c18181902602082015290600160a060020a031615156110765760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b5061107f6115d4565b600360009054906101000a9004600160a060020a0316600160a060020a03166302e4af016040518163ffffffff1660e060020a02815260040160a060405180830381600087803b1580156110d257600080fd5b505af11580156110e6573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060a081101561110b57600080fd5b506002546040517ff3c2dc7e0000000000000000000000000000000000000000000000000000000081523360048201818152939450600160a060020a039092169263f3c2dc7e92918591906024018260a080838360005b8381101561117a578181015183820152602001611162565b5050505090500192505050602060405180830381600087803b15801561119f57600080fd5b505af11580156111b3573d6000803e3d6000fd5b505050506040513d60208110156111c957600080fd5b5060019250505090565b600160205260009081526040902054600160a060020a031681565b60006111f86115d4565b600254604080518082019091526006815260d160020a6518189c181819026020820152600091600160a060020a031615156112785760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600354604080518082019091526006815260d160020a6518189c18181902602082015290600160a060020a031615156112f75760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50600254604080517fe9e085e4000000000000000000000000000000000000000000000000000000008152600481018790529051600160a060020a039092169163e9e085e49160248082019260e092909190829003018186803b15801561135d57600080fd5b505afa158015611371573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525060e081101561139657600080fd5b50805160c08201519096602090920195509350915050565b60005460408051808201909152600681526000805160206115f4833981519152602082015290600160a060020a0316331461142e5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b50604080518082019091526006815260d160020a6518189c181819026020820152600160a060020a03821615156114aa5760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b5060008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b3360009081526001602090815260408083205481518083019092526006825260d160020a6518189c181819029282019290925290600160a060020a031615156115a15760405160e560020a62461bcd028152600401808060200182810382528381815181526020019150805190602001908083836000838110156105fb5781810151838201526020016105e3565b505060028054600160a060020a03831673ffffffffffffffffffffffffffffffffffffffff199091161790556001919050565b60a060405190810160405280600590602082028038833950919291505056fe3031383030310000000000000000000000000000000000000000000000000000a165627a7a72305820c282547e0ecaf54d10ca39de3b3e14e613c20c8239d377ce879681e2c414f9f10029";

    public static final String FUNC_SETLOTTERYRANDOMADDR = "setLotteryRandomAddr";

    public static final String FUNC_GETLOTTERY = "getLottery";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_GETCURRENTLOTTERYINDEX = "getCurrentLotteryIndex";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_LOTTERYCONTRACTADDR = "lotteryContractAddr";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_GETCURRENTLOTTERY = "getCurrentLottery";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_LOTTERYRANDOMADDR = "lotteryRandomAddr";

    public static final String FUNC_ADDLOTTERY = "addLottery";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_GETLOTTERYBYINDEX = "getLotteryByIndex";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETLOTTERYCONTRACTADDR = "setLotteryContractAddr";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected LotteryService(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected LotteryService(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected LotteryService(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected LotteryService(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> setLotteryRandomAddr(String _lotteryRandomAddr) {
        final Function function = new Function(
                FUNC_SETLOTTERYRANDOMADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _lotteryRandomAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>> getLottery(BigInteger beginIndex, BigInteger endIndex) {
        final Function function = new Function(FUNC_GETLOTTERY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(beginIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(endIndex)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<StaticArray5<Uint8>>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>>(function,
                new Callable<Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>>() {
                    @Override
                    public Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<String>, List<List<BigInteger>>, List<BigInteger>>(
                                convertToNative((List<Address>) results.get(0).getValue()), 
                                convertToNative((List<StaticArray5<Uint8>>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> deleteAdmin(String addr) {
        final Function function = new Function(
                FUNC_DELETEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> withdraw(BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> getCurrentLotteryIndex() {
        final Function function = new Function(FUNC_GETCURRENTLOTTERYINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> kill(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<String> lotteryContractAddr() {
        final Function function = new Function(FUNC_LOTTERYCONTRACTADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> ZERO_ADDRESS() {
        final Function function = new Function(FUNC_ZERO_ADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getCurrentLottery() {
        final Function function = new Function(FUNC_GETCURRENTLOTTERY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> addAdmin(String addr) {
        final Function function = new Function(
                FUNC_ADDADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> NOT_OWNER() {
        final Function function = new Function(FUNC_NOT_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> lotteryRandomAddr() {
        final Function function = new Function(FUNC_LOTTERYRANDOMADDR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addLottery() {
        final Function function = new Function(
                FUNC_ADDLOTTERY, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> adminMap(String param0) {
        final Function function = new Function(FUNC_ADMINMAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>> getLotteryByIndex(BigInteger index) {
        final Function function = new Function(FUNC_GETLOTTERYBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<StaticArray5<Uint8>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, List<BigInteger>, BigInteger>>(function,
                new Callable<Tuple3<String, List<BigInteger>, BigInteger>>() {
                    @Override
                    public Tuple3<String, List<BigInteger>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, List<BigInteger>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                convertToNative((List<Uint8>) results.get(1).getValue()), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setLotteryContractAddr(String _lotteryContractAddr) {
        final Function function = new Function(
                FUNC_SETLOTTERYCONTRACTADDR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _lotteryContractAddr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public List<ReceivedHpbEventResponse> getReceivedHpbEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RECEIVEDHPB_EVENT, transactionReceipt);
        ArrayList<ReceivedHpbEventResponse> responses = new ArrayList<ReceivedHpbEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, ReceivedHpbEventResponse>() {
            @Override
            public ReceivedHpbEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(RECEIVEDHPB_EVENT, log);
                ReceivedHpbEventResponse typedResponse = new ReceivedHpbEventResponse();
                typedResponse.log = log;
                typedResponse.sender = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ReceivedHpbEventResponse> receivedHpbEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(RECEIVEDHPB_EVENT));
        return receivedHpbEventFlowable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    @Deprecated
    public static LotteryService load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryService(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static LotteryService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LotteryService(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static LotteryService load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new LotteryService(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static LotteryService load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new LotteryService(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<LotteryService> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryService.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<LotteryService> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryService.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryService> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryService.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<LotteryService> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(LotteryService.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
