import java.io.IOException;
import java.util.Scanner;

class User extends Top  // ��� Ŭ������ ��� ���� �θ� Ŭ����
{

    String cartCheck;

    // ���� ���� ���� �� ����
    int money = 0; // ����ڰ� ���� �� �ݾ� (���µǸ� �ȵǹǷ�)

    public void buy() throws IOException //�����ϱ� �޼ҵ�
    {
        Scanner sc = new Scanner(System.in);
        int price = ca.getPrice(); // ��ٱ��Ͽ� ���� ������ �� �ݾ�
        int unit = 0; // �ִ� ����(����)�� ����
        int number = 0; // ����(����) ����
        int changes; // �ܵ� ����
        System.out.println("��ٱ��Ͽ� ��� ������ �� �ݾ��� " + price + "�� �Դϴ�.");

        do
        {
            System.out.println("\n��¥�� ����(����)�� �����ʴϱ�?");
            System.out.println("[1] 10000����");
            System.out.println("[2] 5000����");
            System.out.println("[3] 1000����");
            System.out.println("[4] 500��");
            System.out.println("[5] 100��");
            System.out.println("[6] ����ϱ�");
            System.out.println("���� ���� �ݾ��� " + money + "�� �Դϴ�.");
            System.out.print(">> �޴� ���� (1~6) : ");
            unit = sc.nextInt(); // ����, ���� ���� �Է�
            if(unit <= 5 && unit >= 1)
            {
                System.out.print(">> �� �� �����ʴϱ�? : ");
                number = sc.nextInt(); // ���� ����
                switch (unit)
                {
                    case 1: money += 10000 * number; break;
                    case 2: money += 5000 * number; break;
                    case 3: money += 1000 * number; break;
                    case 4: money += 500 * number; break;
                    case 5: money += 100 * number; break;
                }
                unit = -1;
            }
        }
        while ((unit > 5 || unit < 1) && unit != 6);


        if (price > money)
        {
            System.out.println("���� �ݾ��� ���ڶ��ϴ�.\n");
            buy(); // ����Լ�
        }
        else
        {
            changes = money - price;
            re.addMoney(price); // ���Ϳ� �� �ݾ� �߰��ϱ�

            // ������ ���� ��� �ݿ��ϱ�
            String cartItems = ca.getCartName();
            String[] str = cartItems.split(",");

            for (String a : str)
            {
                iv.sellItems(a, ca.getItemNum(a));
            }

            pb.print(money, changes);

            // ��ٱ��� ����
            ca.deleteAll();
            ca.deletePrice();

        }
        goMenu();

    }

    public void openCart() // īƮ Ȯ�� �޼ҵ�
    {
        cartCheck = ca.getCartItems();
        System.out.println(cartCheck);
    }

    public static void goMenu() throws IOException // �ʱ� �޴� �޼ҵ�
    {
        VendingUI.printMenu();
        VendingUI.menuSelect();
        VendingUI.menuRun();
    }

    public void addCart(String name ,int price) throws IOException  // ��ٱ��� �߰� �޼ҵ�
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n���� �Է� : ");
        int n = sc.nextInt();
        ca.addItems(name, n);
        ca.addPrice(price * n);
        System.out.println("\n��ٱ��� : " + ca.getCartItems());
    }
}