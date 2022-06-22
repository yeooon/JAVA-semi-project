

class PrintBill implements Print
{
    private int num = 1;

    @Override
    public void print()
    {}

    @Override
    public void print(int money, int changes)
    {
        Text te = new Text();

        String name = Top.ca.getCartName();
        String[] str = name.split(",");

        System.out.println("\n          [ ������ ]");
        System.out.println("-----------------------------------");
        System.out.println("      [    �ֹ���ȣ  :  " + num++ + "  ]");
        System.out.println("       ǰ��                ����  ");
        System.out.println("-----------------------------------");
        for(String a : str)
        {
            System.out.println( a + "                " + Top.ca.getItemNum(a) );
        }
        System.out.println("-----------------------------------");
        System.out.println("�ֹ��հ�  :               " + Top.ca.getPrice());
        System.out.println("���� �ݾ� :               " + money);
        System.out.println("��     �� :               " + changes);
        System.out.println("-----------------------------------");
        System.out.println(Top.ch.useChanges(changes));
        System.out.println("\n�������ּż� �����մϴ�.");
        te.print();

        Top.billgee.useBill();
    }
}