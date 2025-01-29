import java.math.*;
import java.security.*;
import java.util.*;

public class RSA{
    BigInteger n, d, e;

    public RSA(int bitLength){
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);

        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(6557);
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message){
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher){
        return cipher.modPow(d, n);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        RSA rsa = new RSA(512);

        System.out.print("Enter a number to encrypt: ");
        BigInteger message = sc.nextBigInteger();

        BigInteger encrypted = rsa.encrypt(message);
        BigInteger decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        sc.close();
    }
}
