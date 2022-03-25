public class LinkedList
{
    private int listCount;
    private Node head;

    public LinkedList()
    {
        head = new Node();
        listCount = 0;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        Node currentNode = head;

        while (currentNode.getNextNode() != null)
        {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
        listCount++;
    }

    public void insert(int data, int position)
    {
        if (position <= listCount && position > 0)
        {
            Node newNode = new Node(data);
            Node currentNode = head;
            for (int i = 1; i < position; i++)
            {
                currentNode = currentNode.getNextNode();
            }

            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
            listCount++;
        }
    }

    public Node get(int position)
    {
        if (position <= listCount && position > 0)
        {
            Node currentNode = head;
            for (int index = 1; index < position; index++)
            {
                currentNode = currentNode.getNextNode();
            }
            return currentNode;
        }
        return null;
    }

    public void remove(int position)
    {
        if (position == 1)
        {
            head = head.getNextNode();
        }
        else if (position <= listCount && position >= 2)
        {
            Node priorNode = get(position - 1);
            priorNode.setNextNode(get(position + 1));
        }
        listCount--;
    }

    public int size()
    {
        return listCount;
    }
}