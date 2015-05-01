# Tools #

We use the follow version control software:
  * GIT
  * GIT-SVN
  * [Stacked GIT](http://procode.org/stgit/#Download). Download the most recent version and read the INSTALL file that in the archive.

# Submitting patches #

If you are not a comitter, but willing to help us improve ZKGrails by submitting a patch. You can follow step below to do so.

$ `git clone git://github.com/zkgrails/zkgrails.git`
or
$ `git clone http://github.com/zkgrails/zkgrails.git`

$ `git checkout -b snapshot origin/snapshot`

Hack it. After you think your code's working and looks fine, then use the following command:

$ `git diff > issue_no.patch`

to get a patch file and submit it to the related issue in the tracker.

## Via Github ##

But if you are familiar with Github, fork ZKGrails into your own repository, hack stuffs and just do a pull request.

# Branching #

## Master and Snapshot ##

There are two important branches in the ZKGrails git repository.

  * The first one is **master**, which is always kept stable.
  * The second one is **snapshot**, which more or less the development branch. Code in this branch can be very unstable.

You will always be working on the **snapshot** branch for fixing bugs and implementing features.

After getting a bug fixed or a feature implemented, please inform the team via the issue tracker. After that, if the issue is verified, its commits will be merged into the **master** branch.

We apply the same convention for stable series. When a new series is decided to have its own branch, we create 2 branches, **master-series**, and **snapshot-series**, for it.
We have **master-0.7.x** as a master branch of the series, say **0.7.x**. To fix bugs or implement new features into the series, please push your codes into **snapshot-0.7.x**. After issues are verified, its commits will be merged into the master branch of that series (in this example **master-0.7.x**).

## Feature branches ##

Feature branches may be created when collaboration is required to implement features. For example, if two committers decide to implement a new feature tracked by [issue 100](https://code.google.com/p/zkgrails/issues/detail?id=100), then a committer may create a new branch, **feat-100**, for it and push this new branch to the repository.

Finally, this feature branch can be deleted from the repository, after committers agree that the implementation for this feature is completed and after merge the changes into the current development branch, the _snapshot-series_.

Naming convention for this kind of branch is **feat-<issue number>**, i.e., **feat-100** is a feature tracked by the [issue #100](https://code.google.com/p/zkgrails/issues/detail?id=#100).

# Coding Convention #

Please use:
  * Unix LF for line breaks.
  * Soft tab, 4 spaces.
  * Google Chrome's comment style:
```
//
// This is a comment.
//
this.is = code

//
// This is a multiple-line
// comment.
//
this.is = "another line of code"
```
  * UTF-8 for source file encoding.