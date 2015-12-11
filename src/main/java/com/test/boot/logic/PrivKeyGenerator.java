package com.test.boot.logic;

import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.DeterministicKey;
import java.math.BigInteger;
import static org.bitcoinj.core.Utils.*;
import static org.bitcoinj.crypto.HDKeyDerivation.createMasterPrivKeyFromBytes;
import static org.bitcoinj.crypto.HDKeyDerivation.deriveChildKey;

/*Генерирует приватные ключи из master private key и chain code*/
public class PrivKeyGenerator {
    String masterPrivateKey;
    String chainCode;

    public PrivKeyGenerator(String masterPrivateKey, String chainCode) {
        this.masterPrivateKey = masterPrivateKey;
        this.chainCode = chainCode;
    }
    /*Преобразовывает master private key и chain code в массив байт, создает родительский детерменированный ключ
     и дальше, с его помочью создает детерменированный ключ потомка */
        public String generatePrivKey() {
        byte[] byteMasterPrivatKey = HEX.decode(masterPrivateKey); // Переводит из шестнадцатеричной в десятичную систему исчисления

        /*перобразует chain code в 256 бит*/
        Sha256Hash hash = Sha256Hash.of(chainCode.getBytes());
        byte[] byteChainCode = hash.getBytes();

        /*создает детерменированый родительский ключ и дальше - детский с помочью параметра child_number = 0,
         что говорит о extended типе ключа*/
        DeterministicKey parent = createMasterPrivKeyFromBytes(byteMasterPrivatKey, byteChainCode);
        DeterministicKey child = deriveChildKey(parent, ChildNumber.ZERO);

        /*преобразовани полученого ключа с BigInteger в String*/
        BigInteger privateChildKey = child.getPrivKey();
        byte[] privateChildKeyBytes = privateChildKey.toByteArray();
        String privateChildKeyString = HEX.encode(privateChildKeyBytes);

        return privateChildKeyString;
    }
}
