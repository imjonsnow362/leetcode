class Solution
{

    /**
     * @param String $num
     * @return String
     */
    public function largestOddNumber($num)
    {
        $num_len = strlen($num);

        for ($i = $num_len; $i >= 0; $i--) {
            $last_num = substr($num, $i, 1);

            if (((intval($last_num) % 2) !== 0)) {
                return  substr($num, 0, $i + 1);
            }
        }
        return "";
    }
}