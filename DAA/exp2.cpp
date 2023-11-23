#include <iostream>

using namespace std;

double power(double base, int exponent) {
    if (exponent == 0) {
        return 1;
    }

    double temp = power(base, exponent / 2);

    if (exponent % 2 == 0) {
        return temp * temp;
    } else {
        return base * temp * temp;
    }
}

int main() {
    double base;
    int exponent;

    cout << "Enter base: ";
    cin >> base;
    cout << "Enter exponent: ";
    cin >> exponent;

    double result = power(base, exponent);

    cout << "Result: " << result << endl;

    return 0;
}
