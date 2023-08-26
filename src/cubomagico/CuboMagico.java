package cubomagico;

import javax.swing.JOptionPane;

public class CuboMagico {

    public static void main(String[] args) {

        int tamanho = 3;
        int cubo[][] = new int[tamanho][tamanho];
        int c1, c2;
        int soma;
        int alvo;
        int linha = 0;
        int col1 = 0, col2 = 0, col0 = 0;
        String msg = "";

        alvo = ((int) (Math.random() * 148)) + 3; // sorteia um número de valor mínimo 3

        for (c1 = 0; c1 < (tamanho - 1); c1++) {
            soma = 0;
            for (c2 = 0; c2 < tamanho; c2++) {

                cubo[c1][c2] = (int) (Math.random() * 51);
                soma += cubo[c1][c2];

                if (c2 == 0) {
                    col0 += cubo[c1][c2];
                }
                if (c2 == 1) {
                    col1 += cubo[c1][c2];
                }
                if (c2 == 2) {
                    col2 += cubo[c1][c2];
                }
            }

            if (soma != alvo) {
                c1--; //sorteia novamente;
            }

            //Testa se os valores das duas primeiras linhas não sobrepõem o alvo
            if (c1 == 1) {
                if (col0 + col1 >= alvo) {
                    c1--;
                }
            }
        }

        //Preenchendo a última linha com os números calculados;
        cubo[2][0] = alvo - (cubo[0][0] + cubo[1][0]);
        cubo[2][1] = alvo - (cubo[0][1] + cubo[1][1]);
        cubo[2][2] = alvo - (cubo[0][2] + cubo[1][2]);

        msg = "Alvo = " + alvo + "\n";

        for (c1 = 0; c1 < tamanho; c1++) {
            linha = 0;
            for (c2 = 0; c2 < tamanho; c2++) {
                msg += cubo[c1][c2] + " | ";
                linha += cubo[c1][c2];
            }
            msg += "   " + linha + "\n"; //Exibe soma das linhas
        }

        col0 = cubo[0][0] + cubo[0][1] + cubo[0][2];
        col1 = cubo[1][0] + cubo[1][1] + cubo[1][2];
        col2 = cubo[2][0] + cubo[2][1] + cubo[2][2];

        msg += "\n";
        msg += col0 + " | " + col1 + " | " + col2;

        JOptionPane.showMessageDialog(null, msg);

    }

}