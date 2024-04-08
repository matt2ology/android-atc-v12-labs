# Lab 05 Learnings

[Lab05_api33](Lab05_api33)

In the lab it starts with creating the app user interface

1. Start by creating a new Android project. Open Android Studio and go to:
   > File -> New -> New Project
2. Select `Empty Activity`, and click **Next**
3. Type Lab05 for the project name, and click **Finish**

## Step 4

4. It then prompts that:
   > You must be sure that `build.gardle` (Module:Lab05) file has the
   > following Kotlin plugin:
   >
   > > id 'kotlin-android-extensions'

However, in modern Android development, the `kotlin-android-extensions` plugin
has been deprecated and is no longer recommended for use. This plugin was
commonly used to enable Kotlin synthetic properties, which allowed for easy
access to views in XML layouts.

Instead of using `kotlin-android-extensions`, the recommended approach is to
use **View Binding** or **Jetpack Compose**. Here's how you can achieve similar
functionality using these alternatives.

Both **View Binding** and **Jetpack Compose** offer better type safety and
performance compared to Kotlin synthetic properties provided by
`kotlin-android-extensions`. Therefore, it's recommended to migrate to these
alternatives for better maintainability and efficiency in modern Android
development.

### View Binding

View Binding generates a binding class for each XML layout file present in your
project. This binding class allows you to access all the views in the layout
with type safety. Here's how to enable View Binding in your build.gradle file:

```groovy
android {
    ...
    viewBinding {
        enabled = true
    }
}
```

With View Binding enabled, you can access views in your activity like this:

```kotlin
private lateinit var binding: ActivityMainBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    // Access views using binding
    binding.textView.text = "Hello, World!"
}
```

### Jetpack Compose

Jetpack Compose is a modern UI toolkit for building native Android UIs entirely
in Kotlin. It uses a declarative approach to define UI components.
With Compose, you don't need to worry about accessing views in XML layouts as
you would in traditional Android development. Here's a basic example of how you
can define a Composable function:

```kotlin
@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}
```

And you can use this composable function directly in your activity:

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Greeting(name = "Android")
            }
        }
    }
}
```

## Step 5

To start designing your app user interface, you should begin with
`activity_main.xml` file. Navigate to
`app -> res -> layout -> activity_main.xml` and open this file in Design mode.

But, that is meant for the **traditional Android development** with XML layout
files (such as `activity_main.xml`); and, so in **Jetpack Compose**, one would
create composable functions that describe their UI components and their behavior.
There's no need to work with XML layout files like `activity_main.xml`.
Instead, one would write your UI directly in Kotlin code.

## Step 6

**Delete “Hello World”** text from the center of this activity layout

Delete line `Greeting("Android")` and the following blocks of code

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab05_api33Theme {
        Greeting("Android")
    }
}
```

