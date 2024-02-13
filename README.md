Github Repo link: https://github.com/patrickyu117/cs4520-assignment1-starter-code/<br> 

What is this application:<br> 
This application is a simple 2 screen application.<br> 
Screen 1 is a login screen. It contains a username and password login field and a login button.<br> 
-To login:<br> 
--Username: admin<br> 
--Password: admin<br> 
Screen 2 displays the products from the product list that is provided in the code.<br> 
--The product can either be food or equipment<br> 
--The product will display an image for the respective product, display the name, price, and expiry date if available<br><br> 

How to run the application:<br> 
--To run this app, simply import all of the files into Android Studio. Once all the files are imported, run the application using an Android phone emulator.<br> 

Application structure:<br> 
MainActivity<br> 
--This is the main activity that hosts the 2 screen mentioned above (2 fragments)<br> 
LoginFragment<br> 
--Fragment that contains the login screen for the applicaiton<br> 
ProductListFragment<br> 
--Fragment that contains the product lists that the user can scroll through<br> 
ProductListAdapter<br> 
--Adapter for the recycler view that handles the view binding and view holding<br>
Product.kt<br>
--This is the class for the products. Given the list of items in the starter code, each item in the list was changed into a Product type<br><br>

Each fragment has its own .xml file with the respective naming in the /res/layout file.<br>
ConstraintLayout was used for all of these views.<br>
RecyclerView was used for the product list and to display each product item.<br>
