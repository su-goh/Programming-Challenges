<h2>1156. Swap For Longest Repeated Character Substring</h2><h3>Medium</h3><hr><div><p>You are given a string <code>text</code>. You can swap two of the characters in the <code>text</code>.</p>

<p>Return <em>the length of the longest substring with repeated characters</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> text = "ababa"
<strong>Output:</strong> 3
<strong>Explanation:</strong> We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> text = "aaabaaa"
<strong>Output:</strong> 6
<strong>Explanation:</strong> Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
</pre>

<p><strong>Example 3:</strong></p>

<pre><strong>Input:</strong> text = "aaabbaaa"
<strong>Output:</strong> 4
</pre>

<p><strong>Example 4:</strong></p>

<pre><strong>Input:</strong> text = "aaaaa"
<strong>Output:</strong> 5
<strong>Explanation:</strong> No need to swap, longest repeated character substring is "aaaaa", length is 5.
</pre>

<p><strong>Example 5:</strong></p>

<pre><strong>Input:</strong> text = "abcdef"
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= text.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>text</code> consist of lowercase English characters only.</li>
</ul>
</div>