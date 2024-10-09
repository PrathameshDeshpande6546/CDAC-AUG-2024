#include <stdio.h>

struct Date {
    int day;
    int month;
    int year;
};

void initDate(struct Date* ptrDate) {
    ptrDate->day = 1;
    ptrDate->month = 1;
    ptrDate->year = 1900; 

}

void printDateOnConsole(struct Date* ptrDate) {
    printf("%d/%d/%d\n", ptrDate->day, ptrDate->month, ptrDate->year);
}

void acceptDateFromConsole(struct Date* ptrDate) {
    printf("Enter day: ");
    scanf("%d", &ptrDate->day);
    printf("Enter month: ");
    scanf("%d", &ptrDate->month); 

    printf("Enter year: ");
    scanf("%d", &ptrDate->year);
}

int main() {
    struct Date myDate;
    int choice;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Initialize Date\n");
        printf("2. Print Date\n");
        printf("3. Accept Date\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                initDate(&myDate); 

                printf("\n");
                break;
            case 2:
                printDateOnConsole(&myDate);
                break;
            case 3:
                acceptDateFromConsole(&myDate); 

                printf("\n");
                break;
            case 4:
                
                return 0;
            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}