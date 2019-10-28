# Databinding
Data binding interfaces with implementations for Android Java and Kotlin. No code generation.
You can easily extend it but your own!

Latest version: [![](https://jitpack.io/v/codeerow/dsldatabinding.svg)](https://jitpack.io/#codeerow/dsldatabinding)

## Now available:
### View
- visibility
- enabled
- click

### TextView
- text

### Recycler view
- items

### Seekbar
- progress (int)

### Toolbar
- nav button click 

## Installation

Gradle is the only supported build configuration.

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Step 2. Add the dependency
```groovy
dependencies {
        implementation 'com.github.codeerow:dsldatabinding:$version'
}
```

## Usage
ViewModel:
```kotlin
    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
```

LifecycleOwner (e.g. Fragment):
```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding {
            with(inputName) {
                text(viewModel.name, twoWay = true)
            }
            with(inputEmail) {
                text(viewModel.email, twoWay = true)
            }
            with(inputTitle) {
                text(viewModel.title, twoWay = true)
            }
            with(inputDescription) {
                text(viewModel.description, twoWay = true)
            }
        }
    }
```
