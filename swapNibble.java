public static void swapNibble(int number) {
    int left = number & (0XF0);
    int right = number & (0X0F);

    left = left >> 4;
    right = right << 4;

    return left | right;
}
