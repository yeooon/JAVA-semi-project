// �Ǹ� ���� Ŭ����
class Revenue
{
    private static int rev = 0;

    // ���� �߰� �޼ҵ�
    public static void addMoney(int m)
    {
        rev += m;
    }

    // ���� Ȯ�� �޼ҵ�
    public static int getMoney()
    {
        return rev;
    }

    // ���� ȸ�� �޼ҵ�
    public static int removeMoney(int m)
    {
        if(rev >= m)
        {
            rev -= m;
            return 1;
        }
        else
        {
            return -1;
        }
    }
}