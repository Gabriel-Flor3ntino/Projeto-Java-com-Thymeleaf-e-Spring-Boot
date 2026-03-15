package com.br.odevjava.formulario.validation;

public class CPFValidator {
	
	public static boolean isValid(String cpf) {

        if (cpf == null) return false;

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) return false;

        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {

            int soma = 0;
            int peso = 10;

            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int digito1 = 11 - (soma % 11);
            if (digito1 > 9) digito1 = 0;

            soma = 0;
            peso = 11;

            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * peso--;
            }

            int digito2 = 11 - (soma % 11);
            if (digito2 > 9) digito2 = 0;

            return digito1 == (cpf.charAt(9) - '0') &&
                   digito2 == (cpf.charAt(10) - '0');

        } catch (Exception e) {
            return false;
        }
    }

}
