package com.example.numeros;

public class Numero {
    private int numero;

    Numero(int numero) {
        this.numero = numero;
    }

    public Boolean ehPrimo() {
        if (this.numero > 1) {
            for (int i = 2; i < this.numero / 2 + 1; i++) {
                if (this.numero % i == 0) return false;
            }
        }

        if (this.numero < 2) return false;

        return true;
    }

    public String binario() {
        return Integer.toBinaryString(this.numero);
    }

    public String hexadecimal() {
        return Integer.toHexString(this.numero);
    }

    public String corHexadecimal(String numeroHexadecimal) {
        String color = numeroHexadecimal;

        while(color.length() < 6) {
            color += color;
        }

        return "#" + color.substring(0, 6);
    }
}
