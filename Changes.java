import java.util.HashMap;
import java.util.Map;

// �ܵ� Ŭ����
class Changes
{
    private Map<Integer,Integer> changesNum = new HashMap<Integer, Integer>()
    {{
        put(5000, 4);
        put(1000, 20);
        put(500, 30);
        put(100, 50);
    }};

    // �ܵ� ��� Ȯ�� �޼ҵ�
    public int getChanges(int unit)
    {
        return changesNum.get(unit);
    }


    // �ܵ� ��� �޼ҵ�
    public String useChanges(int chan)
    {
        int zandon = chan;
        int ochun = chan/5000;
        int chun = chan%5000/1000;
        int obaek = chan%5000%1000/500;
        int baek = chan%5000%1000/500/100;

        if(changesNum.get(5000) < ochun) // 5000��¥�� ����
        {
            ochun = changesNum.get(5000); // 1���̶� ������ �װŶ� �ܵ��� ���� (�ƿ� ������ 0)
            zandon -= 5000 * ochun;
            chun = zandon/1000;
            if(changesNum.get(1000) < chun)
            {
                chun = changesNum.get(1000);
                zandon -= 1000 * chun;
                obaek = zandon/500;
                if(changesNum.get(500) < obaek) // 500 ����
                {
                    obaek = changesNum.get(500);
                    zandon -= 500 * obaek;
                    baek = zandon/100;
                    if(changesNum.get(100) < baek) // 100 ����
                    {
                        return "�ܵ��� �����մϴ�.";
                    }
                }
                else if(changesNum.get(100) < baek) // 100 ����
                {
                    return "�ܵ��� �����մϴ�.";
                }
            }
            else if(changesNum.get(500) < obaek) // 5000 ����, 1000 ���, 500 ����
            {
                obaek = changesNum.get(500);
                zandon -= 500 * obaek;
                baek = zandon/100;
                if(changesNum.get(100) < baek) // 100 ����
                {
                    return "�ܵ��� �����մϴ�.";
                }
            }
            else if(changesNum.get(100) < baek) // 5000 1000 500 ���, 100 ����
            {
                return "�ܵ��� �����մϴ�.";
            }
        }
        else if(changesNum.get(1000) < chun)
        {
            chun = changesNum.get(1000);
            zandon -= 1000 * chun;
            obaek = zandon/500;
            if(changesNum.get(500) < obaek) // 500��¥���� ������ ���
            {
                obaek = changesNum.get(500);
                zandon -= 500 * obaek;
                baek = zandon/100;
                if(changesNum.get(100) < baek) // 100��¥���� ������ ���
                {
                    return "�ܵ��� �����մϴ�.";
                }
            }
            else if(changesNum.get(100) < baek) // 100��¥���� ������ ���
            {
                return "�ܵ��� �����մϴ�.";
            }
        }
        else if(changesNum.get(500) < obaek) // 5000��¥�� ����, 1000��¥���� ���, 500��¥�� ������ ���
        {
            obaek = changesNum.get(500);
            zandon -= 500 * obaek;
            baek = zandon/100;
            if(changesNum.get(100) < baek) // 100��¥���� ������ ���
            {
                return "�ܵ��� �����մϴ�.";
            }
        }
        else if(changesNum.get(100) < baek) // 5000 1000 500 ���, 100 ����
        {
            return "�ܵ��� �����մϴ�.";
        }

        // ����� �ܵ� ����
        changesNum.put(5000, changesNum.get(5000)-ochun);
        changesNum.put(1000, changesNum.get(1000)-chun);
        changesNum.put(500, changesNum.get(500)-obaek);
        changesNum.put(100, changesNum.get(100)-obaek);

        return "5000�� : " + ochun + "��, " + "1000�� : " + chun + "��, " + "500�� : " + obaek + "��, " + "100�� : " + baek + "��";
    }

    // �ܵ� ��� ä��� �޼ҵ�
    public void addChanges(int unit, int num)
    {
        changesNum.put(unit,changesNum.get(unit)+num);
    }

    // �ܵ� ��� ȸ�� �޼ҵ�
    public int subChanges(int unit, int num)
    {
        if(num > changesNum.get(unit))
        {
            System.out.printf("%d���� �����մϴ�.\n", -(changesNum.get(unit)-num));
            return 0;
        }
        else
        {
            changesNum.put(unit,changesNum.get(unit)-num);
            System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
            return 1;
        }
    }
}