// ���� ��� Ŭ����
class Bill
{
    // ���� ��� (%)
    private static int billNum = 100; //100%

    // ���� ��� Ȯ�� �޼ҵ�
    public static int getBill()
    {
        return billNum;
    }

    // ���� ��� ��, ������ ��� �����ϴ� �޼ҵ�
    public static void useBill()
    {
        billNum--;
    }

    // ���� ��� ä��� �޼ҵ�
    public static void addBill(int num)
    {
        billNum += num;
    }
}

