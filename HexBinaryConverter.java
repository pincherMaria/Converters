/*
Шестнадцатеричный конвертер
*/

public class HexBinaryConverter
{
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args)
    {
        int binaryNumber = 12566;
        //System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "528d9e";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(toBinary(hexNumber)));
    }

    public static String toBinary(int decimalNumber)
    {
        if (decimalNumber <= 0) return "";

        String binary = "";
        while (decimalNumber != 0)
        {
            binary += +decimalNumber % 2;
            decimalNumber /= 2;
        }

        String result = "";
        char[] array = binary.toCharArray();
        for (int i = array.length - 1; i >= 0; i--)
        {
            result += array[i];
        }
        return result;
    }

    /*public static String toHex(int decimalNumber)
    {
        if (decimalNumber <= 0) return "";

        String hex = "";
        while (decimalNumber != 0)
        {
            hex = HEX.charAt(decimalNumber%16) + hex;
            decimalNumber /= 16;
        }
        return hex;
    }*/

    public static int toBinary(String hexNumber)
    {
        if (hexNumber == null || hexNumber.equals("")) return 0;

        int dec = 0;
        for (int i = 0; i < hexNumber.length(); i++)
        {
            int HEXindex = 0;
            for (int j = 0; j < HEX.length(); j++)
            {
                if (HEX.charAt(j) == hexNumber.charAt(i))
                { HEXindex = j; break; }
            }
            dec = 16 * dec + HEXindex;
        }                     /*индекс символа из строки HEX, равного символу из входящей строки с индексом i*/
        return dec;
    }
}