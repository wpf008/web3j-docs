package com.fuxk.quickstart.payment;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;


@Data
public class NftTransactionRecord {
    private Integer id;

    /**
     * 合约地址
     */
    private String contractAddress;

    /**
     * 代付的用户地址
     */
    private String paymentAddress;

    /**
     * 交易hash
     */
    private String txHash;

    /**
     * 0 失败，1 成功，2 待确认
     */
    private Integer status;

    /**
     * nonce值
     */
    private BigInteger nonce;

    /**
     * gas费
     */
    private BigInteger gas;

    /**
     * 此次交易对应的NFT数据记录 [1,2,3]
     */
    private String uuids;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private Integer nftId;

    private Integer type;

    private String userAddress;
}
