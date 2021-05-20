import java.util.Scanner;

public class JobSch { //greedy algorithm

    public void getMaxValue(int machine[]) {
        int max = machine[0];

        for(int i = 0; i < 1; i++) {
            for(int j = i+1; j < machine.length; j++) {
                if(max < machine[j])
                    max = machine[j]; //더 큰 값을 max 에 저장
            }
        }
        System.out.print("기계에 할당되는 가장 긴 시간은 : "+ max);
    }

    public void JobScheduling(int m, int t[]) {
        int machine[] = new int[m];

        for(int i = 0; i < m; i++) {
            machine[i] = 0; //처음에 기계들에 할당된 시간 0
        }

        for(int i = 0; i < t.length; i++) {
            int least = 0; //min 에 해당하는 인덱스의 요소가 가장 작을 것이라 가정
            for(int j = 1; j < m; j++) {
                if(machine[least] > machine[j])
                    least = j; //더 작은 요소의 인덱스 값으로 min 값을 변경.
            }
            machine[least] = machine[least] + t[i]; // 할당된 시간이 적은 기계에 다음 작업 할당해줌.
        }

        //for(int i = 0; i < machine.length; i++) {
        //    System.out.print(machine[i] + " ");
        //} 배열의 요소들 값 확인하는 용도의 for문
        
        getMaxValue(machine);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner 객체 생성
        System.out.print("기계개수: ");
        int m = scanner.nextInt();

        JobSch job = new JobSch();

        System.out.print("입력개수: ");
        int num = scanner.nextInt(); //할당될 작업의 개수

        int time[] = new int[num];
        System.out.print("작업시간을 입력하시오: ");
        for(int i = 0; i<time.length;i++) {
            time[i] = scanner.nextInt(); //할당된 각 작업들의 작업시간
        }

        job.JobScheduling(m, time);
    }
}
