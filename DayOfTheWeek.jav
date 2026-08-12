class Solution {
public:
    string dayOfTheWeek(int day, int month, int year) {
        vector<string> days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int daysInMonths[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        auto isLeap = [](int y) {
            return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        };

        int totalDays = day;

        // Count days for previous years starting from 1971
        for (int y = 1971; y < year; ++y) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        // Count days for previous months in the current year
        for (int m = 1; m < month; ++m) {
            if (m == 2 && isLeap(year)) {
                totalDays += 29;
            } else {
                totalDays += daysInMonths[m];
            }
        }

        // January 1, 1971 was a Friday. 
        // 1 day total means Jan 1, 1971. Friday is index 5 in our array.
        // (totalDays + 4) % 7 maps 1 -> Friday (index 5)
        return days[(totalDays + 4) % 7];
    }
};