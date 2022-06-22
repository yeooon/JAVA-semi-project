import java.util.HashMap;
import java.util.Map;

class Inventory
{
    private Map<String,Integer> invenNumber = new HashMap<String, Integer>()
    {{
        put("��ȸ�� ���� ����ũ", 30);
        put("��ȸ�� ���� ����ũ", 30);
        put("��ȸ�� ���� ����ũ", 30);
        put("KF80 ���� ����ũ", 30);
        put("KF80 ���� ����ũ", 30);
        put("KF80 ���� ����ũ", 30);
        put("KF94 ���� ����ũ", 30);
        put("KF94 ���� ����ũ", 30);
        put("KF94 ���� ����ũ", 30);
        put("������ �ռҵ���", 10);
        put("����� �ռҵ���", 10);
        put("�ڵ����� �ռҵ���", 10);
        put("�ڰ����� ŰƮ", 10);
    }};

    // ��� �� ��ȯ �޼ҵ�
    public int getInvNum(String name)
    {
        return invenNumber.get(name); //name key �� �ش��ϴ� value �� ��ȯ
    }

    // ��� �߰� �޼ҵ�
    public void addInvNum(String name, int add)
    {

        int num = invenNumber.get(name);
        num += add;
        invenNumber.put(name, num);
    }

    // ��� ���� �޼ҵ�
    public void sellItems(String name, int sell)
    {
        invenNumber.put(name, invenNumber.get(name)-sell);
    }

    // ��ü ��� �� ��ȯ �޼ҵ�
    public String getInvens()
    {
        String invens = "";

        for (Map.Entry<String, Integer> entry : invenNumber.entrySet())
        {
            invens += entry.getKey() + " - " + entry.getValue() + "�� \n";
        }
        System.out.println();
        return invens;

    }
}