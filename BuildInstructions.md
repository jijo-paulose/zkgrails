# Build from source #

1. You need the `repo` script used by Google's Android. Then create a directory for example `zkgrails`.

```
$ mkdir zkgrails
$ cd zkgrails
```

2. You then can init the ZKGrails repository locally into your machine using the following command.

```
$ repo init -u git@github.com:zkgrails/manifest.git
```

3. Synchronize your repository.

```
$ repo sync
```

4. You may find `build.sh` script into your directory. Pass 2 parameters to it and it builds ZKGrails and other related projects. For example,

```
$ build.sh 5.0.6 1.1-M1
```

will fetch ZK 5.0.6, and use it to build ZKGrails 1.1-M1.