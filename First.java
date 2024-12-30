class First {
    public static void main(String[] args) {
        String str = "Hello World";
        char[] str1 = new char[str.length()];
        int len = str.length();

        for (int i = 0; i < len; i++) {
            str1[i] = (char) (str.charAt(i) ^ 0); // XOR with 0 (no change to the character)
            System.out.print(str1[i]);
        }
        System.out.println();
    }
}
