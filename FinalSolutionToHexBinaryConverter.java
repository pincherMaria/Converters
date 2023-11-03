package handmade;
/*
Двоично-шестнадцатеричный конвертер
*/

public class FinalSolutionToHexBinaryConverter
{

    private static String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        //String binaryNumber = null;
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.equals(""))
            return "";

        StringBuilder sB = new StringBuilder(binaryNumber);
        char[] binArray = binaryNumber.toCharArray();

        for (int i = 0; i < binArray.length; i++)
        {
            if (binArray[i] != '0' && binArray[i] != '1')
            {
                return "";
            }
        }

        while (binArray.length % 4 != 0)
        {
            sB.reverse();
            sB.append("0");
            sB.reverse();
            String str = sB.toString();
            binArray = str.toCharArray();
        }

        String[] quarters = new String[binArray.length/4];
        int j = 0;
        for (int i = 0; i < quarters.length; i++)
        {
            quarters[i] = "" + binArray[j] + binArray[j+1] + binArray[j+2] + binArray[j+3];
            j+=4;
        }

        String[] result = new String[quarters.length];
        for (int i = 0; i < quarters.length; i++)
        {
            if (quarters[i].equals("0000")) result[i] = "0";
            else if (quarters[i].equals("0001")) result[i] = "1";
            else if (quarters[i].equals("0010")) result[i] = "2";
            else if (quarters[i].equals("0011")) result[i] = "3";
            else if (quarters[i].equals("0100")) result[i] = "4";
            else if (quarters[i].equals("0101")) result[i] = "5";
            else if (quarters[i].equals("0110")) result[i] = "6";
            else if (quarters[i].equals("0111")) result[i] = "7";
            else if (quarters[i].equals("1000")) result[i] = "8";
            else if (quarters[i].equals("1001")) result[i] = "9";
            else if (quarters[i].equals("1010")) result[i] = "a";
            else if (quarters[i].equals("1011")) result[i] = "b";
            else if (quarters[i].equals("1100")) result[i] = "c";
            else if (quarters[i].equals("1101")) result[i] = "d";
            else if (quarters[i].equals("1110")) result[i] = "e";
            else if (quarters[i].equals("1111")) result[i] = "f";
        }

        String resultString = "";
        for (int i = 0; i < result.length; i++)
        {
            resultString += result[i];
        }
        return resultString;
    }


    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.equals(""))
            return "";

        char[] hexArray = hexNumber.toCharArray();

        for (int i = 0; i < hexArray.length; i++)
        {
            if (hexArray[i] != '0' && hexArray[i] != '1' && hexArray[i] != '2' && hexArray[i] != 3)
            {
                if (hexArray[i] != '4' && hexArray[i] != '5' && hexArray[i] != '6' && hexArray[i] != '7')
                {
                    if (hexArray[i] != '8' && hexArray[i] != '9' && hexArray[i] != 'a' && hexArray[i] != 'b')
                    {
                        if (hexArray[i] != 'c' && hexArray[i] != 'd' && hexArray[i] != 'e' && hexArray[i] != 'f')
                            return "";
                    }
                }
            }
        }

        String[] quarters = new String[hexArray.length];
        for (int i = 0; i < hexArray.length; i++)
        {
            if (hexArray[i] == '0') quarters[i] = "0000";
            else if (hexArray[i] == '1') quarters[i] = "0001";
            else if (hexArray[i] == '2') quarters[i] = "0010";
            else if (hexArray[i] == '3') quarters[i] = "0011";
            else if (hexArray[i] == '4') quarters[i] = "0100";
            else if (hexArray[i] == '5') quarters[i] = "0101";
            else if (hexArray[i] == '6') quarters[i] = "0110";
            else if (hexArray[i] == '7') quarters[i] = "0111";
            else if (hexArray[i] == '8') quarters[i] = "1000";
            else if (hexArray[i] == '9') quarters[i] = "1001";
            else if (hexArray[i] == 'a') quarters[i] = "1010";
            else if (hexArray[i] == 'b') quarters[i] = "1011";
            else if (hexArray[i] == 'c') quarters[i] = "1100";
            else if (hexArray[i] == 'd') quarters[i] = "1101";
            else if (hexArray[i] == 'e') quarters[i] = "1110";
            else if (hexArray[i] == 'f') quarters[i] = "1111";
        }

        String result = "";
        for (int i = 0; i < quarters.length; i++)
        {
            result += quarters[i];
        }
        return result;
    }
}