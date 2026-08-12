class Solution {
private:
    bool isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    int countDays(string date) {
        int year = stoi(date.substr(0, 4));
        int month = stoi(date.substr(5, 2));
        int day = stoi(date.substr(8, 2));

        int daysInMonths[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = day;
        
        for (int y = 1971; y < year; ++y) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; ++m) {
            if (m == 2 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += daysInMonths[m];
            }
        }

        return totalDays;
    }

public:
    int daysBetweenDates(string date1, string date2) {
        return abs(countDays(date1) - countDays(date2));
    }
};