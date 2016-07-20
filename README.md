# PersonalProject

An Environment IDE that supports users to write program based on Logo language a computer language designed to teach programming to children.


Project summary:
The code segment is a part of project that I am working on to create an Integrated Development Environment IDE that supports users to write program based on Logo language a computer language designed to teach programming to children.

A user types predefined commands on the console, the program passes the commands and execute them then display the output by moving the object on the screen accordingly.

This is an ongoing personal project that I have been working on during my spare time. The project is similar to a group project that I have worked on before, but I have decided to add more features and make it more users friendly.
If you would like to view the  entire project code, please visit: https://github.com/sallymerza/PersonalProject/
MainTabs.java class

The code segment in MainTabs.java class is responsible for adding new tabs to environment when the plus button is clicked
When the plus button is clicked, it calls the addTab() method and passes to it the Scene and  the root which is in instance of the Group class that holds Nodes.

AddTab() calls CreateGeneralTab() which is a general method that declares a tab, binds its size property to ensure that the user can resize the program's screen without affecting the look and functionality of the program, and adds a BoarderPane where all tabs are added.

createGeneralTab() method calls createContent() method responsible for instantiating and adding content for the new tab. Each tab is associated with a canvas that is added to an object stacked on top of each other. I used canvas to allow the object to draw lines on top of the canvas when it is moved on the screen by the user's command.

 Then a  newly created tab is passed to AddBehavor() method that specifies  what happens when the tab is closed or when the focused is changed to another tab.
 
I add each tab to a map and used an inter id to identify them first, so that I can call the specific tab from project's controller ( I use MVC pattern to organize the project). Second, so that I do not lose the tab and its content when switching from one tab to the other. 

I broke the code down into small modules with specific functionality to make the code easier to debug and reuse in other sections of the code. I utilized object oriented programming concepts such as encapsulation by making utility functions in the class except and used getters and setters to modify and access private fields.  I also used techniques such as lambda expression

