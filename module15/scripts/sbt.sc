/**
 * sbt compile will only compiles files in src/main/scala folder
 * sbt test:compile compiles files in both src/main/scala and src/test/scala
 * same applies to sbt it:compile

 * sbt test:console will give scala console with all class path items with all test dependencies and files
 * ~test, will run tests and then wait for any changes in files and will automatically again compiles and runs tests
   or ~ puts it into continous mode
 * hit enter to get out of tilde ~ command

 * build tools: maven, gradle(user DSL groovy),Pants: Twitter’s Open Source Build Tool,
   Bazel by google is gaining attention now a days.

 * maven, gradle, sbt, pants all offer faster incremental compilation for scala projects

 * Settings are used for configurations and tasks are used for building actions
 */