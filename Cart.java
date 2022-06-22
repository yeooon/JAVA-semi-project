import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

// ��ٱ��� Ŭ����
class Cart
{
    // ��ٱ��Ͽ� ��� �� ��ǰ�� ����
    private static Vector<Integer> price = new Vector<Integer>();

    // ��ٱ��Ͽ� ��� ��ǰ�� �� ���� key-value��
    private static Map<String, Integer> nameCount = new HashMap<String, Integer>();

    // �ݾ� �߰� �޼ҵ�
    public void addPrice(int num)
    {
        price.add(num);
    }

    // ��ٱ��Ͽ� ��� Ư�� ��ǰ�� ���� ��ȯ �޼ҵ�
    public int getItemNum(String name)
    {
        return nameCount.get(name);
    }

    // ��ٱ��Ͽ� ��� ��ǰ�� �� �ݾ� ��ȯ �޼ҵ�
    public int getPrice()
    {
        int total = 0;
        for(Integer a : price)
        {
            total += a;
        }
        return total;
    }

    // ��ٱ��Ͽ� ��� ������ �̸��� ���� ��ȯ �޼ҵ�
    public String getCartItems()
    {
        Set key = nameCount.keySet();
        Iterator it = key.iterator();
        String items = "";
        if(it.hasNext())
        {
            for (Map.Entry<String, Integer> entry : nameCount.entrySet())
            {
                items += entry.getKey() + " - " + entry.getValue() + "�� ";
            }
            return items;
        }
        else
        {
            return "-1";
        }

    }

    // ��ٱ��Ͽ� ��� ������ �̸� ��ȯ �޼ҵ�
    public String getCartName()
    {

        String cartName = "";
        for (Map.Entry<String, Integer> entry : nameCount.entrySet())
        {
            cartName += entry.getKey() + ",";
        }
        return cartName;
    }


    // ��ٱ��Ͽ� ���� �߰� (���߿� User�� �ű� ��?)
    public void addItems(String name, int n)
    {
        if(nameCount.containsKey(name))
        {
            nameCount.put(name, nameCount.get(name)+n);
        }
        else
        {
            nameCount.put(name, n);
        }
    }
    //��ٱ��Ͽ� ���� ����
    public void deleteItems(String name,int n)
    {

        if (nameCount.containsKey(name))
        {
            nameCount.put(name,nameCount.get(name)-n);
            System.out.println("�����Ǿ����ϴ�.");


            if (nameCount.get(name)==0)
            {
                nameCount.remove(name);
            }
        }

        String ch = getCartItems();
        System.out.print(ch);
    }

    // ��ٱ��� ����
    public void deleteAll()
    {
        nameCount.clear();
    }

    // ��ٱ��Ͽ� ��� ��ǰ �� �ݾ� ����
    public void deletePrice()
    {
        price.clear();
    }

    // ��ٱ��� Ȯ�� �޼ҵ�
    public void seeCart()
    {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        if(getCartItems().equals("-1"))
        {
            System.out.println("���� ��ٱ��Ͽ� ������ �����ϴ�.");
        }
        else
        {
            System.out.println("\n���� ��ٱ��Ͽ� �� ��ǰ�� \"" + getCartItems() + "\" �Դϴ�.\n");
        }

        do
        {
            System.out.println("\n[�޴� ����]");
            System.out.println("[1] ��ٱ��� ���� ");
            System.out.println("[2] �޴��� ���ư��� ");
            num = sc.nextInt();
        }
        while (num != 1 && num != 2);

        if(num == 1)
        {
            deleteAll();
            System.out.println("��ٱ��ϸ� ������ϴ�.");
        }
    }
}