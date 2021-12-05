package cz.tilseroz.tilserozchain.domain;

import cz.tilseroz.tilserozchain.util.FingerprintUtil;

import java.security.PublicKey;

public class TransactionOutput {

    public String id;
    public PublicKey recipient; //also known as the new owner of these coins.
    public float value; //the amount of coins they own
    public String parentTransactionId; //the id of the transaction this output was created in

    //Constructor
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.recipient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = FingerprintUtil.applySha256(FingerprintUtil.getStringFromKey(reciepient) + value + parentTransactionId);
    }

    //Check if coin belongs to you
    public boolean isMine(PublicKey publicKey) {
        return (publicKey == recipient);
    }
}
