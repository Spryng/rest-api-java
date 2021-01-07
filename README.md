# Spryng Java SDK

This is the repository for the Java SDK for the Spryng SMS platform. The SDK makes it easy to integrate SMS functionalities into your Java project.



### Configuration

The SDK only needs an API key. You can create an API key in your Sprying account settings.

- Log in to your account in [the Spryng dashboard](https://login.spryngsms.com/)
- Under 'My data', click on 'Profile'
- Scroll down to 'REST API keys' and generate a new API key

You can now initialize the SDK as follows:

```java
import com.spryng.Spryng

class Main {
  
  protected final String API_KEY = "{Your API Key}";
  
  public static void main(String[] args) {
    Spryng client = new Spryng(API_KEY);
  }
}
```



### Sending messages

Use the following code to send a message:

```java
import com.spryng.Spryng
import com.spryng.Models.Message;
import com.spryng.Exceptions.RequestException;

class Main {
  
  protected final String API_KEY = "{Your API Key}";
  
  public static void main(String[] args) {
    Spryng client = new Spryng(API_KEY);
    
    Message message = new Message();
    message.body = "Some message";
    message.recipients = new String[]{"123456789"}; // A phone number
    message.reference = "some-unique-identifier";
    message.originator = "My Company";
    message.route = "business";

    try {
      Message sendMsg = this.client.message.create(message);
    } catch (RequestException e) {
      System.out.println("Something went wrong while attempting to send SMS: " +e.getMessage());
    }
  }
}
```



### Listing Messages

You can list out previously sent messages as follows:

```java
import com.spryng.Spryng
import com.spryng.Models.Message;
import com.spryng.Models.MessageList;

class Main {
  
  protected final String API_KEY = "{Your API Key}";
  
  public static void main(String[] args) {
    Spryng client = new Spryng(API_KEY);
    
    MessageList messages = Spryng.client.message.list(ArrayList<>());

    for (Message message : messages.data) {
      System.out.println(message.id + ": " + message.body);
    }
  }
}
```



### Get credit balance

You can programmatically check the credit balance that you have left with this code:

```java
import com.spryng.Spryng
import com.spryng.Models.Message;
import com.spryng.Exceptions.RequestException;

class Main {
  
  protected final String API_KEY = "{Your API Key}";
  
  public static void main(String[] args) {
    Spryng client = new Spryng(API_KEY);
    
    Balance balance = Spryng.client.balance.get();

    System.out.println("Credits left: " + balance.amount);
  }
}
```

