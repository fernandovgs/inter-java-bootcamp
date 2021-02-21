package digital.innovation.one.testingpasswords;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class TestingPasswords {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String passwdToTest;

        while ((passwdToTest = br.readLine()) != null) {
            System.out.println(matchPasswd(passwdToTest) ? "Senha valida." : "Senha invalida.");
        }
	}

	private static Boolean matchPasswd(String passwd) {
        return passwd.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,32}")
                && passwd.matches("^[a-zA-Z0-9]*$");
    }
}
