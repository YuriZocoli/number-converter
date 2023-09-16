import java.util.Scanner;

class Prog {
    public static void main(String args[]){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Input base: ");
        Integer baseAtual = leitor.nextInt();
        System.out.print("Target base: ");
        Integer baseFinal = leitor.nextInt();
        System.out.print("Precision: ");
        Integer precision = leitor.nextInt();
        System.out.print("Number to convert: ");
        String numero = leitor.next();
        leitor.close();
        
        try {
            Double numeroDecimal;
            numeroDecimal = somethingToDecimal(numero, baseAtual);
            decimalToSomething(numeroDecimal.intValue(), baseFinal);
            fractionalPart((numeroDecimal - numeroDecimal.intValue()), baseFinal, precision);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Double somethingToDecimal(String numeroStr, Integer base) throws Exception{
        String[] partesNumero;
        String strParteFracionaria;
        String strParteInteira;
        if(numeroStr.contains(".") || numeroStr.contains(",")){
            partesNumero = numeroStr.split(numeroStr.contains(".") ? "." : ",");
            strParteFracionaria = partesNumero[1];
            strParteInteira = partesNumero[0];
        }else{
            strParteInteira = numeroStr;
            strParteFracionaria = "0";
        }
        Integer potencia = 0;
        Double decimal = Double.valueOf("0");
        Double fracional = Double.valueOf("0");
        for(int i = (strParteInteira.length()-1); i >= 0; i--){
            decimal += Math.pow(base, potencia) * getNumericValue(strParteInteira.charAt(i), base);
            potencia++;
        }
        potencia = strParteFracionaria.length() > 1 ? (strParteFracionaria.length())*-1: 0;
        for(int i = (strParteFracionaria.length()-1); i >= 0; i--){
            fracional += Math.pow(base, potencia) * getNumericValue(strParteFracionaria.charAt(i), base);
            potencia++;
        }
        return decimal+fracional;
    }

    private static void decimalToSomething(Integer numeroDecimal, Integer base) throws Exception{
        if(numeroDecimal>0){
            decimalToSomething(numeroDecimal/base, base);
            System.out.print(getCharacterValue(numeroDecimal%base, base));
        }
    }

    private static void fractionalPart(Double numeroFracionado, Integer base, Integer precision) throws Exception{
        int integralPart;
        double number;
        if(precision>0){
            System.out.print(",");
        }
        while(precision>0) {
          integralPart=(int) (numeroFracionado*base);
          System.out.print(getCharacterValue(integralPart, base));
          number=numeroFracionado*base;
          numeroFracionado=number-integralPart;
          precision--;
        }
    }

    private static char getCharacterValue(int number, Integer base) throws Exception{
        if(number >= 10){
            switch (number) {
                case 10:
                    return 'A';
                    
                case 11:
                    return 'B';
                    
                case 12:
                    return 'C';
                    
                case 13:
                    return 'D';
                    
                case 14:
                    return 'E';
                    
                case 15:
                    return 'F';
                    
                case 16:
                    return 'G';
                    
                case 17:
                    return 'H';
                    
                case 18:
                    return 'I';
                    
                case 19:
                    return 'J';
                    
                case 20:
                    return 'K';
                    
                case 21:
                    return 'L';
                    
                case 22:
                    return 'M';
                    
                case 23:
                    return 'N';
                    
                case 24:
                    return 'O';
                    
                case 25:
                    return 'P';
                    
                case 26:
                    return 'Q';
                    
                case 27:
                    return 'R';
                    
                case 28:
                    return 'S';
                    
                case 29:
                    return 'T';
                    
                case 30:
                    return 'U';
                    
                case 31:
                    return 'V';
                    
                case 32:
                    return 'W';
                    
                case 33:
                    return 'X';
                    
                case 34:
                    return 'Y';
                    
                case 35:
                    return 'Z';
            
                default:
                    throw new Exception("Convertion erro");
            }
        }
        return Character.forDigit(number,10);
    }

    private static int getNumericValue(char value, Integer base) throws Exception{
        if(Character.isDigit(value)){
            return Character.getNumericValue(value);
        }else if(base > 10){
            int number;
            switch (value) {
                case 'a':
                    number = 10;
                    break;
                
                case 'A':
                    number = 10;
                    break;

                case 'b':
                    number = 11;
                    break;
                    
                case 'B':
                    number = 11;
                    break;

                case 'c':
                    number = 12;
                    break;
                    
                case 'C':
                    number = 12;
                    break;
                    
                case 'd':
                    number = 13;
                    break;
                    
                case 'D':
                    number = 13;
                    break;
                    
                case 'e':
                    number = 14;
                    break;
                    
                case 'E':
                    number = 14;
                    break;
                    
                case 'f':
                    number = 15;
                    break;
                    
                case 'F':
                    number = 15;
                    break;
                    
                case 'g':
                    number = 16;
                    break;
                    
                case 'G':
                    number = 16;
                    break;
                    
                case 'h':
                    number = 17;
                    break;
                    
                case 'H':
                    number = 17;
                    break;
                    
                case 'i':
                    number = 18;
                    break;
                    
                case 'I':
                    number = 18;
                    break;
                    
                case 'j':
                    number = 19;
                    break;
                    
                case 'J':
                    number = 19;
                    break;
                    
                case 'k':
                    number = 20;
                    break;
                    
                case 'K':
                    number = 20;
                    break;
                    
                case 'l':
                    number = 21;
                    break;
                    
                case 'L':
                    number = 21;
                    break;
                    
                case 'm':
                    number = 22;
                    break;
                    
                case 'M':
                    number = 22;
                    break;
                    
                case 'n':
                    number = 23;
                    break;
                    
                case 'N':
                    number = 23;
                    break;
                    
                case 'o':
                    number = 24;
                    break;
                    
                case 'O':
                    number = 24;
                    break;
                    
                case 'p':
                    number = 25;
                    break;
                    
                case 'P':
                    number = 25;
                    break;
                    
                case 'q':
                    number = 26;
                    break;
                    
                case 'Q':
                    number = 26;
                    break;
                    
                case 'r':
                    number = 27;
                    break;
                    
                case 'R':
                    number = 27;
                    break;
                    
                case 's':
                    number = 28;
                    break;
                    
                case 'S':
                    number = 28;
                    break;
                    
                case 't':
                    number = 29;
                    break;
                    
                case 'T':
                    number = 29;
                    break;
                    
                case 'u':
                    number = 30;
                    break;
                    
                case 'U':
                    number = 30;
                    break;
                    
                case 'v':
                    number = 31;
                    break;
                    
                case 'V':
                    number = 31;
                    break;
                    
                case 'w':
                    number = 32;
                    break;
                    
                case 'W':
                    number = 32;
                    break;
                    
                case 'x':
                    number = 33;
                    break;
                    
                case 'X':
                    number = 33;
                    break;
                    
                case 'y':
                    number = 34;
                    break;
                    
                case 'Y':
                    number = 34;
                    break;
                    
                case 'z':
                    number = 35;
                    break;
                    
                case 'Z':
                    number = 35;
                    break;
            
                default:
                    throw new Exception("invalid character");
            }
            return number;
        }
        throw new Exception("invalid character");
    }
}