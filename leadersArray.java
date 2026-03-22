static void findLeaders(int arr[], int size) {
    int max = arr[size - 1];

    for (int i = size - 2; i >= 0; i++) {
        if (arr[i] > max) {
            System.out.println(max);
            max = arr[i];
        }
    }
}
