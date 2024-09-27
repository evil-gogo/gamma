package companies.tesco.employee_shift;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Department {
    String departmentName;
    int startTime;
    int endTime;

    public Department(String departmentName, int startTime, int endTime) {
        this.departmentName = departmentName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Solution {
    public static List<int[]> getEmployeeShiftTime(List<Department> departmentsShiftsTime) {
        List<int[]> employeeShiftTime = new ArrayList<>();

        if (departmentsShiftsTime == null || departmentsShiftsTime.isEmpty()) {
            return employeeShiftTime;
        }

        departmentsShiftsTime.sort((a, b) -> Integer.compare(a.startTime, b.startTime));

        Department currentShift = departmentsShiftsTime.get(0);

        for (int i = 1; i < departmentsShiftsTime.size(); i++) {
            Department nextShift = departmentsShiftsTime.get(i);

            if (currentShift.endTime >= nextShift.startTime) {
                currentShift.endTime = Math.max(currentShift.endTime, nextShift.endTime);
            } else {
                int[] shift = new int[2];
                shift[0] = currentShift.startTime;
                shift[1] = currentShift.endTime;

                employeeShiftTime.add(shift);

                currentShift = nextShift;
            }
        }

        int[] shift = new int[2];
        shift[0] = currentShift.startTime;
        shift[1] = currentShift.endTime;
        employeeShiftTime.add(shift);

        return employeeShiftTime;
    }

    public static void main(String[] args) {
        List<Department> departmentsShiftsTime = new ArrayList<>();

        departmentsShiftsTime.add(new Department("Bakery", 8, 10));
        departmentsShiftsTime.add(new Department("Checkout", 10, 12));
        departmentsShiftsTime.add(new Department("Bakery", 11, 13));
        departmentsShiftsTime.add(new Department("Diary", 18, 19));

        List<int[]> employeeShiftTime = getEmployeeShiftTime(departmentsShiftsTime);

        for (int[] shift : employeeShiftTime) {
            System.out.println(Arrays.toString(shift));
        }
    }
}

