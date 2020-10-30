package PR9;

public class INN
{
    private String INN;
    private String name;

    public INN(String INN, String name)
    {
        this.INN = INN;
        this.name = name;
    }

    public String getINN()
    {
        return INN;
    }

    public String getName()
    {
        return name;
    }

    static String[] fiobase = new String[]
            {"Лапенко В.И.", "Кирилов А.В.", "Меньшиков И.А."};

    static String[] innbase = new String[]
            {"62870756298", "834276549876", "967545353417"};

    public void CheckINN(String inn, String name) throws NoINN, NoFIO
    {
        int a = 0;
        for (int i = 0; i < 3; i++)
        {
            if(name == fiobase[i])
            {
                if(inn != innbase[i])
                    throw new NoINN(this);
                break;
            }
            else if(name != fiobase[i])
            {
                a++;
            }
        }
        if (a == 3)
        {
            throw new NoFIO(this);
        }
    }

    public static void Check(PR9.INN acc)
    {
        try
        {
            acc.CheckINN(acc.getINN(), acc.getName());
            System.out.println("ИНН клиента " + acc.getName() + " совпадает с базой данных.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());;
        }
    }

    public static void main(String[] args)
    {
        PR9.INN client = new INN("62870756298","Лапенко В.И.");
        PR9.INN.Check(client);

        PR9.INN client1 = new INN("834276549876","Кирилов А.В.");
        PR9.INN.Check(client1);

        PR9.INN client2 = new INN("967545353417","Меньшиков И.А.");
        PR9.INN.Check(client2);

        PR9.INN client3 = new INN("967545353417","ОдинДваТри А.В.");
        PR9.INN.Check(client3);

        PR9.INN client4 = new INN("12321321321","Меньшиков И.А.");
        PR9.INN.Check(client4);
    }
}