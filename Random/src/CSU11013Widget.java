public class CSU11013Widget
{
    PFont stdFont;
    final int EVENT_BUTTON1 = 1;
    final int EVENT_BUTTON2 = 2;
    final int EVENT_NULL = 0;
    Widget widget1, widget2;
    ArrayList widgetList;


    void setup()
    {
        stdFont = createFont("Arial", 15);
        textFont(stdFont);
        Widget red = new Widget(100, 100, 180, 40, "RED WIDGET", color(100), stdFont, EVENT_BUTTON1);
        size(400, 400);
        widgetList = new ArrayList();
        widgetList.add(red);
    }

    void draw()
    {
        for (int i = 0; i < widgetList.size(); i++)
        {
            Widget aWidget = (Widget) widgetList.get(i);
            aWidget.draw();
        }
    }

    void mousePressed()
    {
        int event;

        for (int i = 0; i < widgetList.size(); i++)
        {
            Widget aWidget = (Widget) widgetList.get(i);
            event = aWidget.getEvent(mouseX, mouseY);
            switch (event)
            {
                case EVENT_BUTTON1:
                    println("button 1!");
                    break;
                case EVENT_BUTTON2:
                    println("button 2!");
                    break;
            }
        }
    }
}
