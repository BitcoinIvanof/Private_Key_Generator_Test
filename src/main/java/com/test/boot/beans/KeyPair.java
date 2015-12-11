package com.test.boot.beans;


/*модель представления*/
public class KeyPair {
    private String pass;
    private String chain;


    public KeyPair(String pass, String chain) {
        this.pass = pass;
        this.chain = chain;
    }

    public String getPass() {
        return pass;
    }

    public String getChain() {
        return chain;
    }

    @Override
    public String toString() {
        return "KeyPair{" +
                ", pass='" + pass + '\'' +
                ", chain='" + chain+ '\'' +
                '}';
    }
}
