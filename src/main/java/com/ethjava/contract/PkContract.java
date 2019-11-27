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
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
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
public class PkContract extends Contract {
    private static final String BINARY = "60806040908152600060038190558054600160a060020a03199081163317808355600160a060020a03168083526001602052928220805490911690921790915562000053906401000000006200005a810204565b5062000319565b600381905560028054600091620000759060018301620001ba565b5060026003548154811015156200008857fe5b90600052602060002090600302016001016080604051908101604052806000600160a060020a03168152602001600060010281526020016000604051908082528060200260200182016040528015620000eb578160200160208202803883390190505b50815260006020918201819052835460018082018087559583529183902084516004909202018054600160a060020a031916600160a060020a0390921691909117815583830151918101919091556040830151805191926200015692600285019290910190620001ee565b50606082015181600301555050504360026003548154811015156200017757fe5b6000918252602082206003909102019190915560405183917fefb1426e86a130e38e072c3f4c48dba7a8b5832eabaca49e6cf75edb6373543491a2506001919050565b815481835581811115620001e957600302816003028360005260206000209182019101620001e991906200023e565b505050565b8280548282559060005260206000209081019282156200022c579160200282015b828111156200022c5782518255916020019190600101906200020f565b506200023a9291506200026f565b5090565b6200026c91905b808211156200023a5760008082556200026260018301826200028c565b5060030162000245565b90565b6200026c91905b808211156200023a576000815560010162000276565b5080546000825560040290600052602060002090810190620002af9190620002b2565b50565b6200026c91905b808211156200023a578054600160a060020a0319168155600060018201819055620002e86002830182620002f9565b5060006003820155600401620002b9565b5080546000825590600052602060002090810190620002af91906200026f565b6114ad80620003296000396000f3fe6080604052600436106100df577c0100000000000000000000000000000000000000000000000000000000600035046327e1f7df81146101175780632e1a7d4d1461015e578063404097231461017b57806341c0e1b51461022657806344a290f01461022e578063534e13a214610255578063538ba4f91461027f578063704802751461030957806371d78b121461033c57806382bc45be146103515780638da5cb5b1461040857806391d1289114610439578063962aeff8146104fe578063dbbc830b14610528578063f2fde38b1461055b578063f3e41a9914610590575b60408051348152905133917f7129701436f0cdc265d1e2cda298e8a1ccd6ed5fce7f69343e16530b07a2e06e919081900360200190a2005b34801561012357600080fd5b5061014a6004803603602081101561013a57600080fd5b5035600160a060020a03166105a5565b604080519115158252519081900360200190f35b61014a6004803603602081101561017457600080fd5b5035610731565b34801561018757600080fd5b506101ab6004803603604081101561019e57600080fd5b5080359060200135610803565b6040518085600160a060020a0316600160a060020a0316815260200184815260200180602001838152602001828103825284818151815260200191508051906020019060200280838360005b8381101561020f5781810151838201526020016101f7565b505050509050019550505050505060405180910390f35b61014a610a09565b34801561023a57600080fd5b50610243610a9c565b60408051918252519081900360200190f35b34801561026157600080fd5b506102436004803603602081101561027857600080fd5b5035610aa2565b34801561028b57600080fd5b50610294610ac6565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102ce5781810151838201526020016102b6565b50505050905090810190601f1680156102fb5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561031557600080fd5b5061014a6004803603602081101561032c57600080fd5b5035600160a060020a0316610aeb565b34801561034857600080fd5b50610294610bcf565b34801561035d57600080fd5b5061014a6004803603604081101561037457600080fd5b8135919081019060408101602082013564010000000081111561039657600080fd5b8201836020820111156103a857600080fd5b803590602001918460208302840111640100000000831117156103ca57600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929550610bf4945050505050565b34801561041457600080fd5b5061041d610c9a565b60408051600160a060020a039092168252519081900360200190f35b34801561044557600080fd5b5061014a6004803603606081101561045c57600080fd5b600160a060020a038235169160208101359181019060608101604082013564010000000081111561048c57600080fd5b82018360208201111561049e57600080fd5b803590602001918460208302840111640100000000831117156104c057600080fd5b919080806020026020016040519081016040528093929190818152602001838360200280828437600092019190915250929550610ca9945050505050565b34801561050a57600080fd5b506101ab6004803603602081101561052157600080fd5b5035610f2b565b34801561053457600080fd5b5061041d6004803603602081101561054b57600080fd5b5035600160a060020a0316610f4d565b34801561056757600080fd5b5061058e6004803603602081101561057e57600080fd5b5035600160a060020a0316610f68565b005b34801561059c57600080fd5b5061014a6110cf565b600080546040805180820190915260068152600080516020611442833981519152602082015290600160a060020a031633146106625760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360005b8381101561062757818101518382015260200161060f565b50505050905090810190601f1680156106545780820380516001836020036101000a031916815260200191505b509250505060405180910390fd5b50600160a060020a03828116600090815260016020908152604091829020548251808401909352600683526000805160206114628339815191529183019190915290911615156106f75760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5050600160a060020a03166000908152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff1916905590565b600080546040805180820190915260068152600080516020611442833981519152602082015290600160a060020a031633146107b25760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5030318211156107c157600080fd5b60008054604051600160a060020a039091169184156108fc02918591818181858888f193505050501580156107fa573d6000803e3d6000fd5b50600192915050565b60008060606000600354861115151561081b57600080fd5b6108236112d9565b600280548890811061083157fe5b90600052602060002090600302016040805190810160405290816000820154815260200160018201805480602002602001604051908101604052809291908181526020016000905b8282101561092157600084815260209081902060408051608081018252600486029092018054600160a060020a0316835260018101548385015260028101805483518187028101870185528181529495929493860193928301828280156108ff57602002820191906000526020600020905b8154815260200190600101908083116108eb575b5050505050815260200160038201548152505081526020019060010190610879565b5050509152505060208101515190915060011061093d57600080fd5b600060028881548110151561094e57fe5b600091825260208083208a845260026003909302019190910190526040902054905080151561097c57600080fd5b602082015180518290811061098d57fe5b602090810290910181015151908301518051839081106109a957fe5b90602001906020020151602001518360200151838151811015156109c957fe5b90602001906020020151604001518460200151848151811015156109e957fe5b6020908102909101015160600151929b919a509850909650945050505050565b600080546040805180820190915260068152600080516020611442833981519152602082015290600160a060020a03163314610a8a5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b50600054600160a060020a0316ff5b90565b60035481565b6002805482908110610ab057fe5b6000918252602090912060039091020154905081565b6040805180820190915260068152600080516020611462833981519152602082015281565b600080546040805180820190915260068152600080516020611442833981519152602082015290600160a060020a03163314610b6c5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b50600160a060020a038281166000908152600160205260409020541615610b9257600080fd5b50600160a060020a03166000818152600160208190526040909120805473ffffffffffffffffffffffffffffffffffffffff191690921790915590565b6040805180820190915260068152600080516020611442833981519152602082015281565b336000908152600160209081526040808320548151808301909252600682526000805160206114628339815191529282019290925290600160a060020a03161515610c845760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b50610c90338484610ca9565b5060019392505050565b600054600160a060020a031681565b336000908152600160209081526040808320548151808301909252600682526000805160206114628339815191529282019290925290600160a060020a03161515610d395760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5060006002600354815481101515610d4d57fe5b600091825260208083208784526002600390930201919091019052604090205490508015610d7a57600080fd5b6002600354815481101515610d8b57fe5b9060005260206000209060030201600101805490509050806002600354815481101515610db457fe5b90600052602060002090600302016002016000868152602001908152602001600020819055506002600354815481101515610deb57fe5b6000918252602080832060408051608081018252600160a060020a03808c1682528185018b81529282018a8152426060840152600160039097029094018601805480880180835591895297869020835160049099020180549890921673ffffffffffffffffffffffffffffffffffffffff19909816979097178155915194820194909455905180519192610e87926002850192909101906112f1565b50606082015181600301555050508360035486600160a060020a03167f7df050a625d0dbb7e2b2f8407605255c3aeabf3d379a97b12602a0f256eab7b986426040518080602001838152602001828103825284818151815260200191508051906020019060200280838360005b83811015610f0c578181015183820152602001610ef4565b50505050905001935050505060405180910390a4506001949350505050565b60008060606000610f3e60035486610803565b93509350935093509193509193565b600160205260009081526040902054600160a060020a031681565b6000546040805180820190915260068152600080516020611442833981519152602082015290600160a060020a03163314610fe85760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5060408051808201909152600681526000805160206114628339815191526020820152600160a060020a03821615156110665760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5060008054604051600160a060020a03808516939216917f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e091a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b336000908152600160209081526040808320548151808301909252600682526000805160206114628339815191529282019290925290600160a060020a0316151561115f5760405160e560020a62461bcd0281526004018080602001828103825283818151815260200191508051906020019080838360008381101561062757818101518382015260200161060f565b5061116e600354600101611173565b905090565b60038190556002805460009161118c906001830161133c565b50600260035481548110151561119e57fe5b90600052602060002090600302016001016080604051908101604052806000600160a060020a03168152602001600060010281526020016000604051908082528060200260200182016040528015611200578160200160208202803883390190505b5081526000602091820181905283546001808201808755958352918390208451600490920201805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039092169190911781558383015191810191909155604083015180519192611276926002850192909101906112f1565b506060820151816003015550505043600260035481548110151561129657fe5b6000918252602082206003909102019190915560405183917fefb1426e86a130e38e072c3f4c48dba7a8b5832eabaca49e6cf75edb6373543491a2506001919050565b60408051808201909152600081526060602082015290565b82805482825590600052602060002090810192821561132c579160200282015b8281111561132c578251825591602001919060010190611311565b5061133892915061136d565b5090565b815481835581811115611368576003028160030283600052602060002091820191016113689190611387565b505050565b610a9991905b808211156113385760008155600101611373565b610a9991905b808211156113385760008082556113a760018301826113b0565b5060030161138d565b50805460008255600402906000526020600020908101906113d191906113d4565b50565b610a9991905b8082111561133857805473ffffffffffffffffffffffffffffffffffffffff191681556000600182018190556114136002830182611423565b50600060038201556004016113da565b50805460008255906000526020600020908101906113d1919061136d56fe30313830303100000000000000000000000000000000000000000000000000003031383030320000000000000000000000000000000000000000000000000000a165627a7a72305820d5e107499f14d1394bdc4cefeca9c75fd06fac69632f70da4f11729845eacbd50029";

    public static final String FUNC_DELETEADMIN = "deleteAdmin";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_GETPKDATABYROUND = "getPkDataByRound";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_CURRENTPKROUND = "currentPkRound";

    public static final String FUNC_PKROUNDS = "pkRounds";

    public static final String FUNC_ZERO_ADDRESS = "ZERO_ADDRESS";

    public static final String FUNC_ADDADMIN = "addAdmin";

    public static final String FUNC_NOT_OWNER = "NOT_OWNER";

    public static final String FUNC_ADDPKDATA = "addPkData";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_ADDPKDATABYPROXY = "addPkDataByProxy";

    public static final String FUNC_GETPKDATA = "getPkData";

    public static final String FUNC_ADMINMAP = "adminMap";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_ADDROUND = "addRound";

    public static final Event RECEIVEDHPB_EVENT = new Event("ReceivedHpb", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event ADDPKROUND_EVENT = new Event("AddPkRound", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    public static final Event ADDPKDATA_EVENT = new Event("AddPkData", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Uint256>(true) {}, new TypeReference<Bytes32>(true) {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    @Deprecated
    protected PkContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PkContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PkContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PkContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
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

    public RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>> getPkDataByRound(BigInteger round, byte[] no) {
        final Function function = new Function(FUNC_GETPKDATABYROUND, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(round), 
                new org.web3j.abi.datatypes.generated.Bytes32(no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>>(function,
                new Callable<Tuple4<String, byte[], List<byte[]>, BigInteger>>() {
                    @Override
                    public Tuple4<String, byte[], List<byte[]>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, byte[], List<byte[]>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> kill(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<BigInteger> currentPkRound() {
        final Function function = new Function(FUNC_CURRENTPKROUND, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> pkRounds(BigInteger param0) {
        final Function function = new Function(FUNC_PKROUNDS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> ZERO_ADDRESS() {
        final Function function = new Function(FUNC_ZERO_ADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteFunctionCall<TransactionReceipt> addPkData(byte[] no, List<byte[]> data) {
        final Function function = new Function(
                FUNC_ADDPKDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(no), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addPkDataByProxy(String addr, byte[] no, List<byte[]> data) {
        final Function function = new Function(
                FUNC_ADDPKDATABYPROXY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, addr), 
                new org.web3j.abi.datatypes.generated.Bytes32(no), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(data, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>> getPkData(byte[] no) {
        final Function function = new Function(FUNC_GETPKDATA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(no)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, byte[], List<byte[]>, BigInteger>>(function,
                new Callable<Tuple4<String, byte[], List<byte[]>, BigInteger>>() {
                    @Override
                    public Tuple4<String, byte[], List<byte[]>, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, byte[], List<byte[]>, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                convertToNative((List<Bytes32>) results.get(2).getValue()), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<String> adminMap(String param0) {
        final Function function = new Function(FUNC_ADMINMAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addRound() {
        final Function function = new Function(
                FUNC_ADDROUND, 
                Arrays.<Type>asList(), 
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

    public List<AddPkRoundEventResponse> getAddPkRoundEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDPKROUND_EVENT, transactionReceipt);
        ArrayList<AddPkRoundEventResponse> responses = new ArrayList<AddPkRoundEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddPkRoundEventResponse typedResponse = new AddPkRoundEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.round = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddPkRoundEventResponse> addPkRoundEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddPkRoundEventResponse>() {
            @Override
            public AddPkRoundEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDPKROUND_EVENT, log);
                AddPkRoundEventResponse typedResponse = new AddPkRoundEventResponse();
                typedResponse.log = log;
                typedResponse.round = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddPkRoundEventResponse> addPkRoundEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDPKROUND_EVENT));
        return addPkRoundEventFlowable(filter);
    }

    public List<AddPkDataEventResponse> getAddPkDataEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ADDPKDATA_EVENT, transactionReceipt);
        ArrayList<AddPkDataEventResponse> responses = new ArrayList<AddPkDataEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddPkDataEventResponse typedResponse = new AddPkDataEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.round = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.no = (byte[]) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.data = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<AddPkDataEventResponse> addPkDataEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, AddPkDataEventResponse>() {
            @Override
            public AddPkDataEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ADDPKDATA_EVENT, log);
                AddPkDataEventResponse typedResponse = new AddPkDataEventResponse();
                typedResponse.log = log;
                typedResponse.addr = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.round = (BigInteger) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.no = (byte[]) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.data = (List<byte[]>) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.blockTime = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<AddPkDataEventResponse> addPkDataEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDPKDATA_EVENT));
        return addPkDataEventFlowable(filter);
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
    public static PkContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new PkContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PkContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PkContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PkContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new PkContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PkContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PkContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PkContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(PkContract.class, web3j, credentials, contractGasProvider, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<PkContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue) {
        return deployRemoteCall(PkContract.class, web3j, transactionManager, contractGasProvider, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<PkContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(PkContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<PkContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(PkContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static class ReceivedHpbEventResponse extends BaseEventResponse {
        public String sender;

        public BigInteger amount;
    }

    public static class AddPkRoundEventResponse extends BaseEventResponse {
        public BigInteger round;
    }

    public static class AddPkDataEventResponse extends BaseEventResponse {
        public String addr;

        public BigInteger round;

        public byte[] no;

        public List<byte[]> data;

        public BigInteger blockTime;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
