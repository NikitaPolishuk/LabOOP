class Task3
 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) 
        {
        String str = args[i];
        String reversedStr = "";

        for (int j = str.length() - 1; j >= 0; j--) 
        {
        reversedStr += str.charAt(j);
        }
        args[i] = reversedStr;

        }

///////////////////////////////////////////////////////////////////////
        for (int i = 0; i < args.length / 2; i++) 
        {
            String temp = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;
        }
////////////////////////////////////////////////////////////////////////
        for (String str : args) 
        {
            System.out.println(str);
        }
    }
}