## Installation

Web3j can be installed  using  as follows：

### maven构建项目

```
<dependency>
    <groupId>org.web3j</groupId>
    <artifactId>core</artifactId>
    <version>5.0.0</version>
</dependency>
```

### Gradle构建项目

`````
implementation group: 'org.web3j', name: 'core', version: '5.0.0'
`````

需要不同版本的请移步这里：https://mvnrepository.com/artifact/org.web3j/core

## Using Web3j

### Local Providers

```java
 Web3j localWeb3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));//通过http创建Web3j
```

注：http://127.0.0.1:7545 此节点是使用 [ganache ](https://trufflesuite.com/ganache/)启动的一个本地节点。启动后默认的

![](\imgs\ganache-main.png)

```java
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import java.util.List;
import java.util.concurrent.ExecutionException;
public class LocalProviders {
    public static Web3j buildWeb3j() {
        Web3j localWeb3j = Web3j.build(new HttpService("http://127.0.0.1:7545"));
        return localWeb3j;
    }
    public static void main(String[] args) {
        Web3j web3j = buildWeb3j();
        try {
            EthAccounts ethAccounts = web3j.ethAccounts().sendAsync().get();
            List<String> accounts = ethAccounts.getAccounts();
            for (String account : accounts) {
                EthGetBalance ethGetBalance = web3j.ethGetBalance(account, DefaultBlockParameterName.LATEST).sendAsync().get();
                System.out.println(account + " balance is " + ethGetBalance.getBalance());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```

![](\imgs\LocalProviders.png)

### Test Provider

### Remote Providers

## Getting Blockchain Info