# DSL Databinding
Pure Kotlin DSL databinding implementation. No code generation.

Latest version: [![](https://jitpack.io/v/codeerow/dsldatabinding.svg)](https://jitpack.io/#codeerow/dsldatabinding)

## Now available:
### View
- visibility

### TextView
- text

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
```kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databinding {
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

        configureToolbar()
        configureSendUseCase()
    }
```
