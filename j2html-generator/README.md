# J2Html Generator

A webapp to help developers generate J2Html java code from HTML.

## Features

* Build snippets
* Build UI Docs tests

## TODO:

```
For example, <code>&lt;section&gt;</code> should be wrapped as inline.
```
* need a join() for this example

```
<pre><code>&lt;p&gt;Sample text here...&lt;/p&gt;
&lt;p&gt;And another line of sample text here...&lt;/p&gt;
</code></pre>
```
* handle new lines breaking because "" can't be broken across multiple lines

```
<p>
  <var>y</var> = <var>m</var><var>x</var> + <var>b</var>
</p>
```
* join() always puts space between mx

```
<p>
  To switch directories, type <kbd>cd</kbd> followed by the name of the directory.
  <br>
  To edit settings, press <kbd><kbd>Ctrl</kbd> + <kbd>,</kbd></kbd>
</p>
```
* splits up the text way too much

* do I need to identify inline elements?

* make the test template optional but don't lose the context (allow a name)