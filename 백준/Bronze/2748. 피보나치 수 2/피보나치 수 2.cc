#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

long int fibo(int input, long int *arr) {
  if (input == 1 || input == 2) {
    return 1;
  }

  for (int i = 3; i <= input; i++) {
    arr[i] = arr[i - 1] + arr[i - 2];
  }
  return arr[input];
}

int main() {
  int input;
  long int arr[90 + 1] = {
      0,
  };
  arr[1] = 1;
  arr[2] = 1;
  cin >> input;
  cout << fibo(input, arr);
}