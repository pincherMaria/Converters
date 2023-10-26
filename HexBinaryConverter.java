/*
Шестнадцатеричный конвертер
*/

public class HexBinaryConverter
{
    private static final String HEX = "0123456789abcdef";
    private static final char[] HEXarray = HEX.toCharArray();

    public static void main(String[] args)
    {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber)
    {
        char[] binaryArray = binaryNumber.toCharArray();
        //блок проверки аргумента на содержание подходящих символов
        {
            for (int i = 0; i < binaryArray.length; i++)
            {
                if (Character.getNumericValue(binaryArray[i]) != 0 && Character.getNumericValue(binaryArray[i]) != 1)
                    return null;
            }
        }
        //блок обеспечения кратности длины аргумента числу 4
        {
            while (binaryArray.length % 4 != 0)
            {
                invert(binaryArray);
                String stringArray = arrayToString(binaryArray);
                stringArray += "0";
                binaryArray = stringArray.toCharArray();
                invert(binaryArray);
            }
        }

        //основной блок
        {
            String[] quarters = new String[binaryArray.length/4];
            for (int i = 0; i < binaryArray.length; )
            {
                int k = 0;
                for (int j = 0; j < i+4; j++)
                {
                    quarters[k  ] = String.valueOf(binaryArray[j]);
                }
                k++; i+=4;
            }

            for (int i = 0; i < quarters.length; i++)
            {
                System.out.println(quarters[i]);
            }
        }
        return null;
    }

    public static String toBinary(String hexNumber)
    {
        //блок проверки аргумента на содержание подходящих символов
        {
            char[] array = hexNumber.toCharArray();
            char[] hexArray = HEX.toCharArray();
            String check = "";
            for (int i = 0; i < array.length; i++)
            {
                for (int j = 0; j < hexArray.length; j++)
                {
                    if (array[i] == (hexArray[j]))
                    {
                        check += array[i];
                        break;
                    }
                }
            }
            char[] checkArray = check.toCharArray();
            if (checkArray.length != array.length)
                return null;
        }

        return null;
    }

    static void invert(char[] array)
    {
        char[] array2 = array;
        for (int i = 0; i < array.length; i++)
        {
            array2[i] = array[array.length-1-i];
        }
    }

    static String arrayToString(char[] array)
    {
        String stringArray = "";
        for (int i = 0; i < array.length; i++)
        {
            stringArray += array[i];
        }
        return stringArray;
    }
}