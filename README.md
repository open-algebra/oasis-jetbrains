<img src="docs/Owl.svg" alt="OASIS Owl Logo" width="25%">
<small>Credit: Mansi Panwar for artwork</small>

# OASIS JetBrains: OASIS Plugins for JetBrains IDEs

OASIS JetBrains is a collection of plugins for JetBrains IDEs that enhance the development experience
for [OASIS](https://github.com/open-algebra/Oasis)
projects. These plugins provide features such as syntax highlighting and error checking specifically tailored for OASIS
development.

---

## Plugins

### [OasisPALM-IDEA](./OasisPALM-IDEA/README.md)

OasisPALM-IDEA is a JetBrains plugin that provides syntax highlighting and error checking for OASIS PALM files.

---

## Building from Source

This project uses Gradle as its build system. Below are the step-by-step instructions to build the plugins from source.

### Requirements

- JVM 21 or higher
- Gradle 7.0 or higher
- JetBrains IDE (e.g., IntelliJ IDEA)
- Git

### Build Steps

1. Clone the Repository

```shell script
git clone https://github.com/open-algebra/oasis-jetbrains.git
cd oasis-jetbrains
```

2. Build the Plugins

```shell script
./gradlew buildPlugin
```

3. Locate the Built Plugins
   The built plugin files can be found in the `build/distributions` directory of each plugin module.

4. Install the Plugins in JetBrains IDE
    - Open your JetBrains IDE.
    - Go to `File` > `Settings` (or `Preferences` on macOS).
    - Navigate to `Plugins`.
    - Click on the gear icon and select `Install Plugin from Disk`.
    - Browse to the `build/distributions` directory and select the plugin ZIP file.
    - Restart the IDE to activate the plugin.

---

## Contributing to OASIS

We welcome contributions! Whether you're fixing a bug, implementing a new feature, or improving documentation, feel free
to submit a pull request. Check out the [contributing guide](https://github.com/open-algebra/Oasis) for details.

---
